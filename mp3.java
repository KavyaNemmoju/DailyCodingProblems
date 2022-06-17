package com.demo.mp3;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Component("autowiredSongInfo")
public class SongInfo {
    @Autowired
    public SongsRepository songsRepository;
    @Autowired
    Songs s;
    public File[] getSongs(){
        File folder = new File("/home/kavyanemmooju/Downloads/songs");
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".mp3");
            }
        };
        return folder.listFiles(filter);
    }
    public  List<Songs> get() throws SAXException, TikaException,IOException {
        SongInfo songInfo = new SongInfo();
        File[] listOfFiles = songInfo.getSongs();
        List<Songs> songs = new ArrayList<>();
        AutoDetectParser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        int n=1;
        for(File file :listOfFiles) {
            FileInputStream stream = new FileInputStream(file);
            ParseContext context = new ParseContext();
            parser.parse(stream, handler, metadata, context);
            String[] metadataNames = metadata.names();
            String[] metadatainfo = new String[9];
            int q=0;
            for (String name: metadataNames) {
                metadatainfo[q] = metadata.get(name);
                System.out.println(name +"   "+metadata.get(name));
                q++;
            }
            int p=1;
            s.setId(n);
            s.setAudio(metadatainfo[p++]);
            s.setchanelname(metadatainfo[p++]);
            s.setAudioCompressor(metadatainfo[p++]);
            s.setAudioChannelType(metadatainfo[p++]);
            s.setVersion(metadatainfo[p++]);
            s.setDuration(metadatainfo[p++]);
            s.setContentType(metadatainfo[p++]);
            songsRepository.save(s);
            n++;
        }
        return songs;
    }
}

