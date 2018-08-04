package fileCopier.bigFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Date;

import javax.swing.filechooser.FileSystemView;

public class MovingFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File src = new File("C:/Users/lakhminder/Desktop/Delete/RetrieveServices");
		File dest = new File("C:/Users/lakhminder/Desktop/Delete/target/copiedFile");
		System.out.println(new Date());
		//copy(src, dest);
		copyUsingFileChannel(src, dest);
		System.out.println(new Date());
	}
	
	private static void copy(File infile, File outfile){
        
        
	    try{
	 
	        //Open a stream of bytes to read the file bytes into the program
	        FileInputStream instream = new FileInputStream(infile);
	        //A stream of bytes from the program to the destination
	        FileOutputStream outstream = new FileOutputStream(outfile);
	        byte[] buffer = new byte[1024];
	        int bytesRead;
	        //Write the bytes from the inputstream to the outputstream
	        while((bytesRead = instream.read(buffer))!=-1){
	 
	            outstream.write(buffer, 0, bytesRead);
	             
	        }
	 
	        // Finally close both streams to save garbage disposal memory
	        instream.close();
	        outstream.close();
	        }catch(FileNotFoundException e){e.printStackTrace();
	         
	        }
	         catch(IOException e){e.printStackTrace();}
	         
	        }
private static void copyUsingFileChannel(File infile, File outfile){
        
        
	    try{
	 
	    	FileInputStream source = new FileInputStream(infile);
	        FileOutputStream destination = new FileOutputStream(outfile);
	 
	        FileChannel sourceFileChannel = source.getChannel();
	        FileChannel destinationFileChannel = destination.getChannel();
	 
	        long size = sourceFileChannel.size();
	        sourceFileChannel.transferTo(0, size, destinationFileChannel);
	 
	        // Finally close both streams to save garbage disposal memory
	        source.close();
	        destination.close();
	        }catch(FileNotFoundException e){e.printStackTrace();
	         
	        }
	         catch(IOException e){e.printStackTrace();
	         }finally{
	        	 
	         }
	         
	        }

}
