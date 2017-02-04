package DOHTS;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;


public class ModuleChecker{

	//component variable
	private JFrame frame;
	private static JProgressBar progressBar;
    
	//wait time
	private static final int WAIT_TIME = 4;
	
	//file management variables
    private static String workingDirectory;
    private static ArrayList<File> fileDependenciesDir = new ArrayList<>();
    private static ArrayList<String> fileDependenciesErrors = new ArrayList<>();
    private static final String []fileNames = {};
    private JLabel lblStatus;

	public ModuleChecker() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("DOHTS LMS GUI 0.1");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(720,480));
		frame.setResizable(false);
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 404, 694, 26);
		frame.getContentPane().add(progressBar);
		
		lblStatus = new JLabel("Checking files please wait...",SwingConstants.CENTER);
		lblStatus.setBounds(10, 379, 684, 14);
		frame.getContentPane().add(lblStatus);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ModuleChecker.class.getResource("/assets/img/anim-preloader.gif")));
		lblNewLabel.setBounds(0, 0, 714, 451);
		frame.getContentPane().add(lblNewLabel);
		
		// gets the working directory upon execution
		workingDirectory = System.getProperty("user.dir");
	}
    
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuleChecker window = new ModuleChecker();
					window.frame.setVisible(true);
					if(isDependencyChecked(workingDirectory)){
						System.out.println("All file dependencies checked..");
						System.out.println("Starting timer..");
						if(progressBar.getValue() == 100 && fileDependenciesErrors.isEmpty()){
							Timer timer = new Timer();
							TimerTask task = new TimerTask(){
								int ctr = 0;
								public void run(){
									ctr++;
									window.lblStatus.setText("All files checked. Starting application");
									System.out.println("Closing module checker in " + String.valueOf( WAIT_TIME-ctr));
									if(ctr == WAIT_TIME){
										System.out.println("Closing checker module");
										MainDashboard dashboard = new MainDashboard();
										System.out.println("Displaying dashboard");
										dashboard.showDashboard();
										window.frame.dispose();
										timer.cancel();
									}
								}
							};
							timer.scheduleAtFixedRate(task, 1000, 1000);
						}
					}else{
						//missing files
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static boolean isDependencyChecked(String dir){
        if(fileNames.length > 0){
            int filesCount = 100 / fileNames.length;
            for(String fileName : fileNames){
                fileDependenciesDir.add(new File(dir + "/" + fileName));
            }
            for(File dependency : fileDependenciesDir){
                //checkingDescription.setText("Checking " + dependency.getAbsolutePath());
                if(!dependency.exists()){
                    //if file doesn't exist
                    fileDependenciesErrors.add(dependency.getAbsolutePath());
                }else{
                    progressBar.setValue(progressBar.getValue() + filesCount);
                }
            }
            if(fileDependenciesErrors.size() > 0){
                return false; //there are some files missing
            }else{
                return true; // no missing files in the dependencies. display dashboard
            }
        }else{
            progressBar.setValue(100);
            return true; // no dependencies so display dashboard
        }
	}
}
