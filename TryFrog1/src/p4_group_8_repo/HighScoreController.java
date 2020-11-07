package p4_group_8_repo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author GohXinYee sfyxg1
 *
 */

public class HighScoreController {

	private File scorefile = new File("src/froggerfiles/scorefile.txt");
	private HighScoreView view;
	private HighScoreModel model;
	
	HighScoreController(){};
	
	HighScoreController(HighScoreModel model, HighScoreView view){
		setModel(model);
		setView(view);
		writingHighScore(getModel().getusername(),getModel().getpoints());
		sortingHighScore();
		
	}

	//where we read and write highscores into files
	public void writingHighScore(String name, int points) {
		
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		//PrintWriter pw = null; //fileoutputstream
		
		try {
			
			if(!scorefile.exists()) {
				
				boolean check=scorefile.createNewFile();
				if(check) {
					System.out.println("File created");
				}
					
			}
			
			//System.out.println("File Tracked");
			System.out.println("Recording Score...");
			fw = new FileWriter(scorefile,true);
			bw = new BufferedWriter(fw);
			bw.write(name + "----" + points + "\n");
			//System.out.print();
					
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			
			try {
				
				if(fw!=null && bw!=null) {
					bw.close();
					fw.close();
					
				}
				
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
	
	
	
	public void sortingHighScore() {
		
		
		FileReader fr = null; 
		BufferedReader br = null; 
		ArrayList<HighScoreModel> modelscorelist = new ArrayList<HighScoreModel>();
		
		try {
			//read the file
		fr=new FileReader(scorefile);
		br=new BufferedReader(fr);
	
		String currentline = br.readLine();
		//currentline = br.readLine();
			//not end of file
		while(currentline != null) {
			
			String[] highscoredetails = currentline.split("----",2);
			String name = highscoredetails[0];
			int points = Integer.valueOf(highscoredetails[1]);
			//add it to model list
			modelscorelist.add(new HighScoreModel(name, points));
			currentline = br.readLine();
		}

		//sort the HighScoreModel, with points DSC
		Collections.sort(modelscorelist, new HighScoreComparator());

		//sorted, then write into file, not appending
		BufferedWriter bw = new BufferedWriter(new FileWriter(scorefile));
		
		//pop the HighScoreModel one by one
		for(HighScoreModel currentmodel : modelscorelist) {
			bw.write(currentmodel.getusername() + "----" + currentmodel.getpoints() + "\n"); 
		}
		bw.close();
		
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			try {
				if(fr!=null && br!=null) {
					fr.close();
					br.close();
				}
				
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
	
	
	
	public ArrayList<String> retrievingHighScore() {
		
		
		FileReader fr = null; 
		BufferedReader br = null; 
		ArrayList<String> scorelist = new ArrayList<String>();
		
		try {
		if(!(scorefile.exists())) {
			System.out.println("File doesn't Exist.");
			System.out.println("Creating new file now...");
			boolean check=scorefile.createNewFile();
			if(check) {
				System.out.println("File created");
			}
		}
		
		System.out.println("Retrieving High Score...");
		
		fr=new FileReader(scorefile);
		br=new BufferedReader(fr);
	
		String currentline = br.readLine();
		while(currentline != null) {
			System.out.println(currentline);
			scorelist.add(currentline);
			currentline = br.readLine();
		}
		
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			try {
				if(fr!=null && br!=null) {
					fr.close();
					br.close();
				}
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		return scorelist;
		
	}
	
	public void updateView(int rank, String currenthighscore) {
		getView().addscoretopopupview(rank,currenthighscore);
	}

	public void setModel(HighScoreModel model) {
		this.model = model;
	}
	public HighScoreModel getModel() {
		return this.model;
	}
	
	public HighScoreView getView() {
		return view;
	}

	public void setView(HighScoreView view) {
		this.view = view;
	}
}
