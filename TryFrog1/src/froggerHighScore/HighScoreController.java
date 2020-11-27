package froggerHighScore;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <b>HighScoreController can retrieve {@link froggerHighScore.HighScoreModel} information, 
 * record the information into file in descending order and update to {@link froggerHighScore.HighScoreView}.</b>
 */

public class HighScoreController {

	/**the target file location to record high score*/
	private File scorefile = new File("src/froggerfiles/scorefile.txt");
	
	private HighScoreView view;
	private HighScoreModel model;
	
		
	/**
	 * This constructor will create a {@code HighScoreController} object that sets up its target {@link froggerHighScore.HighScoreModel} and {@link froggerHighScore.HighScoreView} .<br>
	 * It will then record the {@link froggerHighScore.HighScoreModel} information into the {@link HighScoreController#scorefile}. The records will be arranged in descending order. 
	 * @param model the target {@link froggerHighScore.HighScoreModel} 
	 * @param view the target {@link froggerHighScore.HighScoreView} to update to
	 */
	public HighScoreController(HighScoreModel model, HighScoreView view){
		setModel(model);
		setView(view);
		writingHighScore();
		sortingHighScore();
		
	}

	
	/**
	 * Write high score record into file (append mode)
	 * 
	 */
	public void writingHighScore() {
		
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
			bw.write(this.model.getusername() + "----" + this.model.getpoints() + "\n");
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
	 * Sort and arrange the high score records in the file in <b>descending order</b>, from highest score to lowest score.<br>
	 * Sorting done by calling 
	 * <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#sort(java.util.List,%20java.util.Comparator)">{@code Collections.sort}</a> function 
	 * and sort according to {@link froggerHighScore.HighScoreComparator#compare(HighScoreModel, HighScoreModel)}.
	 */
	public void sortingHighScore() {
		
		FileReader fr = null; 
		BufferedReader br = null; 
		ArrayList<HighScoreModel> modelscorelist = new ArrayList<HighScoreModel>();
		
		try {
		
			//read from the file
			fr=new FileReader(scorefile);
			br=new BufferedReader(fr);
	
			//read first line from file
			String currentline = br.readLine();
			
			//while not end of file
			while(currentline != null) {
				
				//extract the line to get username and points
				String[] highscoredetails = currentline.split("----",2);
				String name = highscoredetails[0];
				int points = Integer.valueOf(highscoredetails[1]);
				
				//create a new HighScoreModel with the extracted username and points
				//add the HighScoreModel to a list of HighScoreModel
				modelscorelist.add(new HighScoreModel(name, points));
				currentline = br.readLine();
				
			}

			//sort the HighScoreModel list, with points in descending order
			Collections.sort(modelscorelist, new HighScoreComparator());

			//once sorted, start rewriting into file
			BufferedWriter bw = new BufferedWriter(new FileWriter(scorefile));
		
			//pop the HighScoreModel one by one from the list
			//rewrite it into file in String format
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
	 * @return a list of high score records in String format : <i>username----score</i>
	 */
	public ArrayList<String> retrievingHighScore() {
		
		
		FileReader fr = null; 
		BufferedReader br = null; 
		ArrayList<String> scorelist = new ArrayList<String>();
		
		try {
			
			//create a new file if it doesn't exist
			if(!(scorefile.exists())) {
				System.out.println("File doesn't Exist.");
				System.out.println("Creating new file now...");
				boolean check=scorefile.createNewFile();
				if(check) {
					System.out.println("File created");
				}
			}
		
			System.out.println("Retrieving High Score...");//
		
			fr=new FileReader(scorefile);
			br=new BufferedReader(fr);
	
			//read the first line from file
			String currentline = br.readLine();
			
			//while not end of file, add the highscore record to a list of highscore records
			while(currentline != null) {
				System.out.println(currentline);//
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
	 * update the high score records to the target {@link froggerHighScore.HighScoreView}
	 * @param rank the ranking of the high score record
	 * @param currenthighscore the high score record to be updated to the {@link froggerHighScore.HighScoreView}
	 */
	public void updateView(int rank, String currenthighscore) {
		getView().addscoretopopupview(rank,currenthighscore);
	}

	
	
	/**
	 * setter method for the {@link HighScoreController#model} in {@code HighScoreController} 
	 * @param model the {@link froggerHighScore.HighScoreModel} to be set
	 */
	public void setModel(HighScoreModel model) {
		this.model = model;
	}
	/**
	 * getter method for the {@link HighScoreController#model} in {@code HighScoreController}
	 * @return a {@link froggerHighScore.HighScoreModel} 
	 */
	public HighScoreModel getModel() {
		return this.model;
	}
	
	/**
	 * setter method for the {@link HighScoreController#view} in the {@code HighScoreController}
	 * @param view the {@link froggerHighScore.HighScoreView} to be set
	 */
	public void setView(HighScoreView view) {
		this.view = view;
	}


	/**
	 * getter method for {@link HighScoreController#view} in the {@code HighScoreController}
	 * @return a {@link froggerHighScore.HighScoreView}
	 */
	public HighScoreView getView() {
		return view;
	}
}
