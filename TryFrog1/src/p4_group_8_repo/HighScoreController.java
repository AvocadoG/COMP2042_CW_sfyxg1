package p4_group_8_repo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * HighScoreController can retrieve {@link p4_group_8_repo.HighScoreModel} information, record the information into file in descending order and update to {@link p4_group_8_repo.HighScoreView}.
 * 
 *
 */

public class HighScoreController {

	/**
	 * the target file location
	 */
	private File scorefile = new File("src/froggerfiles/scorefile.txt");
	
	private HighScoreView view;
	private HighScoreModel model;
	
	/**
	 * default constructor
	 */
	HighScoreController(){};
	
	/**
	 * This constructor will create a High Score Controller that will retrieve and record the {@link p4_group_8_repo.HighScoreModel} information into the file and arrange the records in descending order. 
	 *
	 *  
	 * @param model the {@link p4_group_8_repo.HighScoreModel} record to be written into file
	 * @param view the target HighScoreView to update the highscore display
	 */
	HighScoreController(HighScoreModel model, HighScoreView view){
		setModel(model);
		setView(view);
		writingHighScore(getModel().getusername(),getModel().getpoints());
		sortingHighScore();
		
	}

	/**
	 * Write high score record into file (append mode)
	 * @param name the player's username
	 * @param points the player's game points
	 */
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
	
	
	/**
	 * Sort and arrange the high score records in the file.
	 * High score records are arranged in descending order, from highest score to lowest score.<br>
	 * Sorting done by calling {@code Collections.sort}--add a link-- function and using {@link p4_group_8_repo.HighScoreComparator}.
	 */
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

		//sorted, then rewrite into file, not appending
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
	
	
	/**
	 * Retrieve high score records from the file.
	 * @return a list of high score records in String (format : username----score)
	 */
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
	
	
	/**
	 * update the HighScoreView
	 * @param rank The ranking of the high score record
	 * @param currenthighscore The high score record to be updated to the HighScoreView
	 */
	public void updateView(int rank, String currenthighscore) {
		getView().addscoretopopupview(rank,currenthighscore);
	}

	/**
	 * setter method for the HighScoreModel
	 * @param model the HighScoreModel to be set
	 */
	public void setModel(HighScoreModel model) {
		this.model = model;
	}
	/**
	 * getter method for the HighScoreModel
	 * @return a HighScoreModel 
	 */
	public HighScoreModel getModel() {
		return this.model;
	}
	
	/**
	 * getter method for HighScoreView
	 * @return a HighScoreView
	 */
	public HighScoreView getView() {
		return view;
	}

	/**
	 * setter method for the HighScoreView
	 * @param view the HighScoreView to be set
	 */
	public void setView(HighScoreView view) {
		this.view = view;
	}
}
