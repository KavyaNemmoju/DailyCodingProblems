// printing properties of a particular file
import java.io.File;
import java.util.Scanner;
class fileProperty{
	public static void main(String[] args)
	{
		
		Scanner sc=new Scanner(System.in);
		String fname = sc.nextLine();

		
		File f = new File(fname);
		String content[]=f.list();
		for(int i=0;i<content.length;i++){
			if(content[i].endsWith(".txt")){
				System.out.println(content[i]);
			}
			
		}

		// System.out.println("File name :" + f.getName());
		// System.out.println("Path: " + f.getPath());
		// System.out.println("Absolute path:"+ f.getAbsolutePath());
		// System.out.println("Parent:" + f.getParent());
		// System.out.println("Exists :" + f.exists());
		// if (f.exists()) {
			
			
		// 	System.out.println("Is a directory:"+ f.isDirectory());
		// 	System.out.println("File Size in bytes "+ f.length());
		// }
	}
}
