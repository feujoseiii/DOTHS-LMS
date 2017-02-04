package DOHTS;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.List;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ScrollPane;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.*;
import java.util.ArrayList;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class MainDashboard{
	private enum MouseType {
		NORMAL,LINK
	}
	
	private enum Pages {
		HOMEPAGE,
		DISCOVER,
		TAKE_QUIZ,
		ACHIEVEMENTS,
		TAKE_QUIZ_MOD1,
		MODULE1_PART1_PAGE1,
		MODULE1_PART1_PAGE2,
		MODULE1_PART1_PAGE3,
		MODULE1_PART1_PAGE4,
		MODULE1_PART1_PAGE5,
		MODULE1_PART2_PAGE1,
		MODULE1_PART2_PAGE2,
		MODULE1_PART2_PAGE3,
		MODULE1_PART2_PAGE4,
		MODULE1_PART3_PAGE1,
		MODULE1_PART3_PAGE2,
		MODULE1_PART3_PAGE3,
		MODULE1_PART3_PAGE4,
	}
	
	private JFrame frame;
	private JPanel takequizPanel;
	private JPanel homepagePanel;
	private JPanel module1TakeQuizPanel;
	private JPanel module1Part1TakeQuiz1;
	private JPanel module1Part1TakeQuiz2;
	private JPanel module1Part1TakeQuiz3;
	private JPanel module1Part1TakeQuiz4;
	private JPanel module1Part1TakeQuiz5;
	private JPanel module1Part2TakeQuiz1;
	private JPanel module1Part2TakeQuiz2;
	private JPanel module1Part2TakeQuiz3;
	private JPanel module1Part2TakeQuiz4;
	
	public static void showDashboard() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainDashboard window = new MainDashboard();
					window.frame.setVisible(true);	
					//connect to database here

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/* Initialize User Interface */
	public MainDashboard() {
		initialize();
	}
	
	
	private void initialize() {
		
		frame = new JFrame("DOHTS LMS GUI 0.1");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(720,480));
		frame.setSize(new Dimension(1280,720));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setResizable(false);
		
		//main pages
		initialize_homepage(frame);
		initialize_takequizpage(frame);
		
		//main module pages
		initialize_module1(frame);
		
		//module 1 part 1 sub pages
		initialize_module1part1(frame);
		initialize_module1part2(frame);
		initialize_module1part3(frame);
		initialize_module1part4(frame);
		initialize_module1part5(frame);
	
		//set default page to homepage
		changePage(Pages.HOMEPAGE);
	}
	
	
	
	private void changeCursor(JPanel panel, MouseType mouseType){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = null;
		switch(mouseType){
			case NORMAL:
				image = toolkit.getImage(MainDashboard.class.getResource("/assets/img/arrow_cursor.png"));
				break;
			case LINK:
				image = toolkit.getImage(MainDashboard.class.getResource("/assets/img/hand_cursor.png"));
				break;
			default:
				image = toolkit.getImage(MainDashboard.class.getResource("/assets/img/arrow_cursor.png"));
		}
		Cursor cursor = toolkit.createCustomCursor(image ,new Point(panel.getX(),panel.getY()), "img");
		panel.setCursor (cursor);
	}
	
	private void changePage(Pages page){
		switch(page){
			case HOMEPAGE:
				homepagePanel.setVisible(true);
				takequizPanel.setVisible(false);
				module1TakeQuizPanel.setVisible(false);
				module1Part1TakeQuiz1.setVisible(false);
				module1Part1TakeQuiz2.setVisible(false);
				module1Part1TakeQuiz3.setVisible(false);
				module1Part1TakeQuiz4.setVisible(false);
				module1Part1TakeQuiz5.setVisible(false);
				break;
			case DISCOVER:
				break;
			case TAKE_QUIZ:
				takequizPanel.setVisible(true);
				homepagePanel.setVisible(false);
				module1TakeQuizPanel.setVisible(false);
				module1Part1TakeQuiz1.setVisible(false);
				module1Part1TakeQuiz2.setVisible(false);
				module1Part1TakeQuiz3.setVisible(false);
				module1Part1TakeQuiz4.setVisible(false);
				module1Part1TakeQuiz5.setVisible(false);
				break;
			case ACHIEVEMENTS:
				break;
			case TAKE_QUIZ_MOD1:
				module1TakeQuizPanel.setVisible(true);
				takequizPanel.setVisible(false);
				homepagePanel.setVisible(false);
				module1Part1TakeQuiz1.setVisible(false);
				module1Part1TakeQuiz2.setVisible(false);
				module1Part1TakeQuiz3.setVisible(false);
				module1Part1TakeQuiz4.setVisible(false);
				module1Part1TakeQuiz5.setVisible(false);
				break;
			//module 1
			case MODULE1_PART1_PAGE1:
				module1Part1TakeQuiz1.setVisible(true);
				module1TakeQuizPanel.setVisible(false);
				takequizPanel.setVisible(false);
				homepagePanel.setVisible(false);
				module1Part1TakeQuiz2.setVisible(false);
				module1Part1TakeQuiz3.setVisible(false);
				module1Part1TakeQuiz4.setVisible(false);
				module1Part1TakeQuiz5.setVisible(false);				
				break;
			case MODULE1_PART1_PAGE2:
				module1Part1TakeQuiz2.setVisible(true);
				module1TakeQuizPanel.setVisible(false);
				takequizPanel.setVisible(false);
				homepagePanel.setVisible(false);
				module1Part1TakeQuiz1.setVisible(false);
				module1Part1TakeQuiz3.setVisible(false);
				module1Part1TakeQuiz4.setVisible(false);
				module1Part1TakeQuiz5.setVisible(false);
				break;
			case MODULE1_PART1_PAGE3:
				module1Part1TakeQuiz3.setVisible(true);
				module1TakeQuizPanel.setVisible(false);
				takequizPanel.setVisible(false);
				homepagePanel.setVisible(false);
				module1Part1TakeQuiz1.setVisible(false);
				module1Part1TakeQuiz2.setVisible(false);
				module1Part1TakeQuiz4.setVisible(false);
				module1Part1TakeQuiz5.setVisible(false);
				break;
			case MODULE1_PART1_PAGE4:
				module1Part1TakeQuiz4.setVisible(true);
				module1TakeQuizPanel.setVisible(false);
				takequizPanel.setVisible(false);
				homepagePanel.setVisible(false);
				module1Part1TakeQuiz1.setVisible(false);
				module1Part1TakeQuiz2.setVisible(false);
				module1Part1TakeQuiz3.setVisible(false);
				module1Part1TakeQuiz5.setVisible(false);
				break;
			case MODULE1_PART1_PAGE5:
				module1Part1TakeQuiz5.setVisible(true);
				module1TakeQuizPanel.setVisible(false);
				takequizPanel.setVisible(false);
				homepagePanel.setVisible(false);
				module1Part1TakeQuiz1.setVisible(false);
				module1Part1TakeQuiz2.setVisible(false);
				module1Part1TakeQuiz3.setVisible(false);
				module1Part1TakeQuiz4.setVisible(false);
				break;
			default:
				break;
		}
	}
	
	private void initialize_homepage(JFrame frame){
		JLabel navHomeBtn_homepage = new JLabel();
		JLabel navBackBtn_homepage = new JLabel();
		JLabel navForwardBtn_homepage = new JLabel();
		
		/* Home Page .GIF Variables */
		JLabel beakerAnim_homepage = new JLabel();
		JLabel pencilAnim_homepage = new JLabel();
		JLabel trophyAnim_homepage = new JLabel();
		
		/* Home Page Navigation Buttons*/
		JLabel navTakequizBtn_homepage = new JLabel();
		JLabel navDiscoverBtn_homepage = new JLabel();
		JLabel navAchievemtentsBtn_homepage = new JLabel();
		
		/* Other Home Page Component Variables*/
		
		JLabel dohts_logo_homepage = new JLabel();
		JLabel board_homepage = new JLabel();
		JLabel footerBar_homepage = new JLabel();	
		
		homepagePanel = new JPanel();
		homepagePanel.setBackground(SystemColor.controlLtHighlight);
		homepagePanel.setForeground(SystemColor.controlLtHighlight);
		homepagePanel.setLayout(null);
		frame.getContentPane().add(homepagePanel, "name_11029615969405");
		changeCursor(homepagePanel,MouseType.NORMAL);
		
		/*------------- ADD ANIMATIONS TO HOME PAGE PANEL START -------------*/
		trophyAnim_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/active_cup.gif")));
		trophyAnim_homepage.setBounds(28, 496, 108, 135);
		homepagePanel.add(trophyAnim_homepage);
		
		beakerAnim_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/active_beaker.gif")));
		beakerAnim_homepage.setBounds(28, 158, 108, 135);
		homepagePanel.add(beakerAnim_homepage);
		
		pencilAnim_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/active_pencil.gif")));
		pencilAnim_homepage.setBounds(28, 321, 108, 135);
		homepagePanel.add(pencilAnim_homepage);
		/*------------- ADD ANIMATIONS TO HOME PAGE PANEL END -------------*/
		
		
		/*------------- ADD CONTROL BUTTONS TO HOME PAGE PANEL START -------------*/
		
		/*Add Home Button To Panel*/
		navHomeBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_home_passive_v2.png")));
		navHomeBtn_homepage.setBounds(18, 11, 92, 96);
		homepagePanel.add(navHomeBtn_homepage);
		
		/*Add Back Button To Panel*/
		navBackBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_back_passive_v2.png")));
		navBackBtn_homepage.setBounds(120, 11, 92, 96);
		homepagePanel.add(navBackBtn_homepage);
		
		/*Add Forward Button To Panel*/
		navForwardBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_forward_passive_v2.png")));
		navForwardBtn_homepage.setBounds(222, 11, 92, 96);
		homepagePanel.add(navForwardBtn_homepage);
		
		/*------------- ADD CONTROL BUTTONS TO HOME PAGE PANEL END -------------*/
		
		
		/*------------- CONTROL BUTTONS EVENT LISTENER START ---------------------*/
		
		navHomeBtn_homepage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				navHomeBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_home_active_v2.png")));
				changeCursor(homepagePanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				navHomeBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_home_passive_v2.png")));
				changeCursor(homepagePanel,MouseType.NORMAL);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				changePage(Pages.HOMEPAGE);
			}
		});

		navBackBtn_homepage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				navBackBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_back_active_v2.png")));
				changeCursor(homepagePanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				navBackBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_back_passive_v2.png")));
				changeCursor(homepagePanel,MouseType.NORMAL);
			}
		});
		
		navForwardBtn_homepage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				navForwardBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_forward_active_v2.png")));
				changeCursor(homepagePanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				navForwardBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_forward_passive_v2.png")));
				changeCursor(homepagePanel,MouseType.NORMAL);
			}
		});
		
		/*------------- CONTROL BUTTONS EVENT LISTENER END ---------------------*/
		
		
		/*------------- ADD NAVIGATION BUTTONS TO HOME PAGE PANEL START -------------*/
		navDiscoverBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_discover_passive_v2.png")));
		navDiscoverBtn_homepage.setBounds(18, 137, 381, 173);
		homepagePanel.add(navDiscoverBtn_homepage);
		
		navTakequizBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_takequiz_passive_v2.png")));
		navTakequizBtn_homepage.setBounds(18, 310, 381, 166);
		homepagePanel.add(navTakequizBtn_homepage);
		
		navAchievemtentsBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_achievements_passive_v2.png")));
		navAchievemtentsBtn_homepage.setBounds(18, 479, 381, 166);
		homepagePanel.add(navAchievemtentsBtn_homepage);
		/*------------- ADD NAVIGATION BUTTONS TO HOME PAGE PANEL END -------------*/
		
		
		/*------------- NAVIGATION BUTTONS EVENT LISTENER START ---------------------*/
		navDiscoverBtn_homepage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				navDiscoverBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_discover_active_v2.png")));
				changeCursor(homepagePanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				navDiscoverBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_discover_passive_v2.png")));
				changeCursor(homepagePanel,MouseType.NORMAL);
			}
		});
		
		navTakequizBtn_homepage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				navTakequizBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_takequiz_active_v2.png")));
				changeCursor(homepagePanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				navTakequizBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_takequiz_passive_v2.png")));
				changeCursor(homepagePanel,MouseType.NORMAL);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				initialize_takequizpage(frame); //reinitialize takequiz panel to check for available modules
				changePage(Pages.TAKE_QUIZ);
			}
		});

		navAchievemtentsBtn_homepage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				navAchievemtentsBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_achievements_active_v2.png")));
				changeCursor(homepagePanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				navAchievemtentsBtn_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_achievements_passive_v2.png")));
				changeCursor(homepagePanel,MouseType.NORMAL);
			}
		});
		/*------------- NAVIGATION BUTTONS EVENT LISTENER END ---------------------*/
		
		
		/*------------- ADD OTHER COMPONENTS TO HOME PAGE PANEL START -------------*/
		dohts_logo_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/doths_logo_v2.png")));
		dohts_logo_homepage.setBounds(601, 293, 474, 199);
		homepagePanel.add(dohts_logo_homepage);
		
		board_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/board_v2.png")));
		board_homepage.setBounds(409, 141, 855, 504);
		homepagePanel.add(board_homepage);
		
		footerBar_homepage.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		footerBar_homepage.setBounds(0, 670, 1280, 21);
		homepagePanel.add(footerBar_homepage);
		/*------------- ADD OTHER COMPONENTS TO HOME PAGE PANEL START -------------*/
		
	}
	
	private void initialize_takequizpage(JFrame frame){
		takequizPanel = new JPanel();
		takequizPanel.setLayout(null);
		takequizPanel.setForeground(Color.WHITE);
		takequizPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(takequizPanel, "name_25180876777737");
		changeCursor(takequizPanel,MouseType.NORMAL);
		
		ArrayList<JLabel> module_buttons = new ArrayList<JLabel>();
		module_buttons.add(new JLabel()); //module 1 button
		module_buttons.add(new JLabel()); //module 2 button
		module_buttons.add(new JLabel()); //module 3 button
		module_buttons.add(new JLabel()); //module 4 button
		module_buttons.add(new JLabel()); //module 5 button
		
		ArrayList<Rectangle> module_location = new ArrayList<Rectangle>();
		module_location.add(new Rectangle(467, 341, 115, 135));		// 1st module location
		module_location.add(new Rectangle(617, 341, 115, 135));		// 2nd module location
		module_location.add(new Rectangle(773, 341, 115, 135));		// 3rd module location 
		module_location.add(new Rectangle(927, 341, 115, 135));		// 4th module location
		module_location.add(new Rectangle(1080, 341, 115, 135));    // 5th module location
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doths_db?autoReconnect=true&useSSL=false","root","");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM modules WHERE status = 1");
			int ctr = 0;
			while(rs.next()){
				int curr_module = Integer.parseInt(rs.getString("module_name").replace("module", ""))-1;
				module_buttons.get(curr_module).setBounds(module_location.get(ctr));
				takequizPanel.add(module_buttons.get(curr_module));
				ctr++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
		    try { rs.close(); } catch (Exception e) {}
		    try { st.close(); } catch (Exception e) {}
		    try { conn.close(); } catch (Exception e) {}
		}
		
		JLabel discoverAnim_takequiz = new JLabel();
		discoverAnim_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/active_beaker.gif")));
		discoverAnim_takequiz.setBounds(28, 158, 108, 135);
		takequizPanel.add(discoverAnim_takequiz);
		
		JLabel takequizAnim_takequiz = new JLabel();
		takequizAnim_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/active_pencil.gif")));
		takequizAnim_takequiz.setBounds(28, 321, 108, 135);
		takequizPanel.add(takequizAnim_takequiz);
		
		JLabel trophyAnim_takequiz = new JLabel();
		trophyAnim_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/active_cup.gif")));
		trophyAnim_takequiz.setBounds(28, 496, 108, 135);
		takequizPanel.add(trophyAnim_takequiz);
		
		JLabel navHomeBtn_takequiz = new JLabel();
		navHomeBtn_takequiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				navHomeBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_home_passive_v2.png")));
				changeCursor(takequizPanel,MouseType.NORMAL);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				navHomeBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_home_active_v2.png")));
				changeCursor(takequizPanel,MouseType.LINK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				changePage(Pages.HOMEPAGE);
			}
		});
		navHomeBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_home_passive_v2.png")));
		navHomeBtn_takequiz.setBounds(18, 11, 92, 96);
		takequizPanel.add(navHomeBtn_takequiz);
		
		JLabel navBackBtn_takequiz = new JLabel();
		navBackBtn_takequiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				navBackBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_back_active_v2.png")));
				changeCursor(takequizPanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				navBackBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_back_passive_v2.png")));
				changeCursor(takequizPanel,MouseType.NORMAL);
			}
		});
		navBackBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_back_passive_v2.png")));
		navBackBtn_takequiz.setBounds(120, 11, 92, 96);
		takequizPanel.add(navBackBtn_takequiz);
		
		JLabel navForwardBtn_takequiz = new JLabel();
		navForwardBtn_takequiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				navForwardBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_forward_active_v2.png")));
				changeCursor(takequizPanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				navForwardBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_forward_passive_v2.png")));
				changeCursor(takequizPanel,MouseType.NORMAL);
			}
		});
		navForwardBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_forward_passive_v2.png")));
		navForwardBtn_takequiz.setBounds(222, 11, 92, 96);
		takequizPanel.add(navForwardBtn_takequiz);
		
		JLabel navDiscoverBtn_takequiz = new JLabel();
		navDiscoverBtn_takequiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				navDiscoverBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_discover_active_v2.png")));
				changeCursor(takequizPanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				navDiscoverBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_discover_passive_v2.png")));
				changeCursor(takequizPanel,MouseType.NORMAL);
			}
		});
		navDiscoverBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_discover_passive_v2.png")));
		navDiscoverBtn_takequiz.setBounds(18, 137, 381, 173);
		takequizPanel.add(navDiscoverBtn_takequiz);
		
		JLabel navTakequizBtn_takequiz = new JLabel();
		navTakequizBtn_takequiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				navTakequizBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_takequiz_active_v2.png")));
				changeCursor(takequizPanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				navTakequizBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_takequiz_passive_v2.png")));
				changeCursor(takequizPanel,MouseType.NORMAL);
			}
		});
		navTakequizBtn_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_takequiz_passive_v2.png")));
		navTakequizBtn_takequiz.setBounds(18, 310, 381, 166);
		takequizPanel.add(navTakequizBtn_takequiz);
		
		JLabel navAchievements_takequiz = new JLabel();
		navAchievements_takequiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				navAchievements_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_achievements_active_v2.png")));
				changeCursor(takequizPanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				navAchievements_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_achievements_passive_v2.png")));
				changeCursor(takequizPanel,MouseType.NORMAL);
			}
		});
		navAchievements_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/nav_achievements_passive_v2.png")));
		navAchievements_takequiz.setBounds(18, 479, 381, 166);
		takequizPanel.add(navAchievements_takequiz);
		
		JLabel sectionIcon_takequiz = new JLabel("");
		sectionIcon_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/takequiz_section_icon.png")));
		sectionIcon_takequiz.setBounds(670, 192, 321, 101);
		takequizPanel.add(sectionIcon_takequiz);
		
		
		module_buttons.get(0).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				module_buttons.get(0).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module1_active.png")));
				changeCursor(takequizPanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				module_buttons.get(0).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module1_passive.png")));
				changeCursor(takequizPanel,MouseType.NORMAL);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				changePage(Pages.TAKE_QUIZ_MOD1);
			}
		});
		module_buttons.get(0).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module1_passive.png")));
		
		
		module_buttons.get(1).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				module_buttons.get(1).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module2_active.png")));
				changeCursor(takequizPanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				module_buttons.get(1).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module2_passive.png")));
				changeCursor(takequizPanel,MouseType.NORMAL);
			}
		});
		module_buttons.get(1).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module2_passive.png")));
		
		
		module_buttons.get(2).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				module_buttons.get(2).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module3_active.png")));
				changeCursor(takequizPanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				module_buttons.get(2).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module3_passive.png")));
				changeCursor(takequizPanel,MouseType.NORMAL);
			}
		});
		module_buttons.get(2).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module3_passive.png")));
		
		module_buttons.get(3).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				module_buttons.get(3).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module4_active.png")));
				changeCursor(takequizPanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				module_buttons.get(3).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module4_passive.png")));
				changeCursor(takequizPanel,MouseType.NORMAL);
			}
		});
		module_buttons.get(3).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module4_passive.png")));
		
		module_buttons.get(4).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				module_buttons.get(4).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module5_active.png")));
				changeCursor(takequizPanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				module_buttons.get(4).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module5_passive.png")));
				changeCursor(takequizPanel,MouseType.NORMAL);
			}
		});
		module_buttons.get(4).setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module5_passive.png")));
		
		JLabel board_takequiz = new JLabel();
		board_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/board_v2.png")));
		board_takequiz.setBounds(409, 141, 855, 504);
		takequizPanel.add(board_takequiz);
		
		JLabel footer_takequiz = new JLabel();
		footer_takequiz.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		footer_takequiz.setBounds(0, 670, 1280, 21);
		takequizPanel.add(footer_takequiz);
	}
	
	private void initialize_module1(JFrame frame){
		module1TakeQuizPanel = new JPanel();
		module1TakeQuizPanel.setLayout(null);
		module1TakeQuizPanel.setForeground(Color.WHITE);
		module1TakeQuizPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(module1TakeQuizPanel, "name_40841310944660");
		changeCursor(module1TakeQuizPanel,MouseType.NORMAL);
		
		JLabel home_Module1Front = new JLabel();
		home_Module1Front.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changePage(Pages.HOMEPAGE);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				home_Module1Front.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_home_active_v2.png")));
				changeCursor(module1TakeQuizPanel,MouseType.LINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				home_Module1Front.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_home_passive_v2.png")));
				changeCursor(module1TakeQuizPanel,MouseType.NORMAL);
			}
		});
		
		JLabel footer_Module1Front = new JLabel();
		footer_Module1Front.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		footer_Module1Front.setBounds(0, 670, 1280, 21);
		module1TakeQuizPanel.add(footer_Module1Front);
		home_Module1Front.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_home_passive_v2.png")));
		home_Module1Front.setBounds(18, 11, 92, 96);
		module1TakeQuizPanel.add(home_Module1Front);
		
		JLabel back_Module1Front = new JLabel();
		back_Module1Front.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_back_passive_v2.png")));
		back_Module1Front.setBounds(120, 11, 92, 96);
		module1TakeQuizPanel.add(back_Module1Front);
		
		JLabel forward_Module1Front = new JLabel();
		forward_Module1Front.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/control_forward_passive_v2.png")));
		forward_Module1Front.setBounds(222, 11, 92, 96);
		module1TakeQuizPanel.add(forward_Module1Front);
		
		JLabel part1Btn_Module1Front = new JLabel("");
		part1Btn_Module1Front.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changePage(Pages.MODULE1_PART1_PAGE1);
			}
		});
		part1Btn_Module1Front.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module1_part1.png")));
		part1Btn_Module1Front.setBounds(154, 191, 210, 225);
		module1TakeQuizPanel.add(part1Btn_Module1Front);
		
		JLabel part2Btn_Module1Front = new JLabel("");
		part2Btn_Module1Front.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module1_part3.png")));
		part2Btn_Module1Front.setBounds(896, 191, 210, 225);
		module1TakeQuizPanel.add(part2Btn_Module1Front);
		
		JLabel part3Btn_Module1Front = new JLabel("");
		part3Btn_Module1Front.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/module1_part2.png")));
		part3Btn_Module1Front.setBounds(525, 191, 210, 225);
		module1TakeQuizPanel.add(part3Btn_Module1Front);
		
		JLabel background_Module1Front = new JLabel("");
		background_Module1Front.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/grey_background.png")));
		background_Module1Front.setBounds(0, 118, 1280, 573);
		module1TakeQuizPanel.add(background_Module1Front);
	}
	
	private void initialize_module1part1(JFrame frame){
		
		module1Part1TakeQuiz1 = new JPanel();
		module1Part1TakeQuiz1.setLayout(null);
		module1Part1TakeQuiz1.setForeground(Color.WHITE);
		module1Part1TakeQuiz1.setBackground(Color.WHITE);
		frame.getContentPane().add(module1Part1TakeQuiz1, "name_39628175079711");
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0008_Flower.png")));
		lblNewLabel_3.setBounds(150, 128, 223, 195);
		module1Part1TakeQuiz1.add(lblNewLabel_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0006_Cow.png")));
		label_4.setBounds(524, 128, 223, 195);
		module1Part1TakeQuiz1.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0007_Pig.png")));
		label_5.setBounds(898, 128, 223, 195);
		module1Part1TakeQuiz1.add(label_5);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/pig_sign.png")));
		label_7.setBounds(977, 352, 98, 116);
		module1Part1TakeQuiz1.add(label_7);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0004_cow-sign.png")));
		label_6.setBounds(547, 352, 188, 116);
		module1Part1TakeQuiz1.add(label_6);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0005_flower-sign.png")));
		lblNewLabel_4.setBounds(205, 352, 118, 116);
		module1Part1TakeQuiz1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0002_Sign-the-word-that-does-not-belong-to-the-group.png")));
		lblNewLabel_2.setBounds(103, 29, 1067, 49);
		module1Part1TakeQuiz1.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Passive.png")));
		lblNewLabel.setBounds(27, 550, 98, 96);
		module1Part1TakeQuiz1.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0016_3.png")));
		label_1.setBounds(312, 559, 71, 76);
		module1Part1TakeQuiz1.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0017_2.png")));
		label.setBounds(231, 559, 71, 76);
		module1Part1TakeQuiz1.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0013_1.png")));
		lblNewLabel_1.setBounds(150, 559, 71, 76);
		module1Part1TakeQuiz1.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0015_4.png")));
		label_2.setBounds(395, 559, 71, 76);
		module1Part1TakeQuiz1.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0014_5.png")));
		label_3.setBounds(475, 559, 71, 76);
		module1Part1TakeQuiz1.add(label_3);
		
		JLabel footer_Module1Part1 = new JLabel();
		footer_Module1Part1.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		footer_Module1Part1.setBounds(0, 670, 1280, 21);
		module1Part1TakeQuiz1.add(footer_Module1Part1);
		
		JLabel background__Module1Part1 = new JLabel("");
		background__Module1Part1.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/grey_background.png")));
		background__Module1Part1.setBounds(0, 0, 1280, 691);
		module1Part1TakeQuiz1.add(background__Module1Part1);
				
	}
	

	private void initialize_module1part2(JFrame frame){
		module1Part1TakeQuiz2 = new JPanel();
		module1Part1TakeQuiz2.setLayout(null);
		module1Part1TakeQuiz2.setForeground(Color.WHITE);
		module1Part1TakeQuiz2.setBackground(Color.WHITE);
		frame.getContentPane().add(module1Part1TakeQuiz2, "name_11219221049977");
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0005_mango.png")));
		label_8.setBounds(150, 128, 223, 195);
		module1Part1TakeQuiz2.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0003_carrot.png")));
		label_9.setBounds(524, 128, 223, 195);
		module1Part1TakeQuiz2.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0004_cabbage.png")));
		label_10.setBounds(898, 128, 223, 195);
		module1Part1TakeQuiz2.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0000_cabbage.png")));
		label_11.setBounds(918, 352, 193, 116);
		module1Part1TakeQuiz2.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Carrot.png")));
		label_12.setBounds(605, 352, 79, 169);
		module1Part1TakeQuiz2.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0002_Mango.png")));
		label_13.setBounds(193, 352, 150, 146);
		module1Part1TakeQuiz2.add(label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0002_Sign-the-word-that-does-not-belong-to-the-group.png")));
		label_14.setBounds(103, 29, 1067, 49);
		module1Part1TakeQuiz2.add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Passive.png")));
		label_15.setBounds(27, 550, 98, 96);
		module1Part1TakeQuiz2.add(label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0016_3.png")));
		label_16.setBounds(312, 559, 71, 76);
		module1Part1TakeQuiz2.add(label_16);
		
		JLabel label_17 = new JLabel("");
		label_17.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0012_2.png")));
		label_17.setBounds(231, 559, 71, 76);
		module1Part1TakeQuiz2.add(label_17);
		
		JLabel label_18 = new JLabel("");
		label_18.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0013_1.png")));
		label_18.setBounds(150, 559, 71, 76);
		module1Part1TakeQuiz2.add(label_18);
		
		JLabel label_19 = new JLabel("");
		label_19.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0015_4.png")));
		label_19.setBounds(395, 559, 71, 76);
		module1Part1TakeQuiz2.add(label_19);
		
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0014_5.png")));
		label_20.setBounds(475, 559, 71, 76);
		module1Part1TakeQuiz2.add(label_20);
		
		JLabel label_21 = new JLabel();
		label_21.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		label_21.setBounds(0, 670, 1280, 21);
		module1Part1TakeQuiz2.add(label_21);
		
		JLabel label_22 = new JLabel("");
		label_22.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/grey_background.png")));
		label_22.setBounds(0, 0, 1280, 691);
		module1Part1TakeQuiz2.add(label_22);
	}
	
	private void initialize_module1part3(JFrame frame){
		module1Part1TakeQuiz3 = new JPanel();
		module1Part1TakeQuiz3.setLayout(null);
		module1Part1TakeQuiz3.setForeground(Color.WHITE);
		module1Part1TakeQuiz3.setBackground(Color.WHITE);
		frame.getContentPane().add(module1Part1TakeQuiz3, "name_11772908255816");
		
		JLabel label_23 = new JLabel("");
		label_23.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0005_banana.png")));
		label_23.setBounds(150, 128, 223, 195);
		module1Part1TakeQuiz3.add(label_23);
		
		JLabel label_24 = new JLabel("");
		label_24.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0004_fish.png")));
		label_24.setBounds(524, 128, 223, 195);
		module1Part1TakeQuiz3.add(label_24);
		
		JLabel label_25 = new JLabel("");
		label_25.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0003_avocado.png")));
		label_25.setBounds(898, 128, 223, 195);
		module1Part1TakeQuiz3.add(label_25);
		
		JLabel label_26 = new JLabel("");
		label_26.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/avocado_sign.png")));
		label_26.setBounds(924, 352, 170, 116);
		module1Part1TakeQuiz3.add(label_26);
		
		JLabel label_27 = new JLabel("");
		label_27.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/fish_sign.png")));
		label_27.setBounds(564, 352, 174, 116);
		module1Part1TakeQuiz3.add(label_27);
		
		JLabel label_28 = new JLabel("");
		label_28.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/banana_sign.png")));
		label_28.setBounds(173, 352, 190, 134);
		module1Part1TakeQuiz3.add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0002_Sign-the-word-that-does-not-belong-to-the-group.png")));
		label_29.setBounds(103, 29, 1067, 49);
		module1Part1TakeQuiz3.add(label_29);
		
		JLabel label_30 = new JLabel("");
		label_30.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Passive.png")));
		label_30.setBounds(27, 550, 98, 96);
		module1Part1TakeQuiz3.add(label_30);
		
		JLabel label_31 = new JLabel("");
		label_31.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0011_3.png")));
		label_31.setBounds(312, 559, 71, 76);
		module1Part1TakeQuiz3.add(label_31);
		
		JLabel label_32 = new JLabel("");
		label_32.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0012_2.png")));
		label_32.setBounds(231, 559, 71, 76);
		module1Part1TakeQuiz3.add(label_32);
		
		JLabel label_33 = new JLabel("");
		label_33.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0013_1.png")));
		label_33.setBounds(150, 559, 71, 76);
		module1Part1TakeQuiz3.add(label_33);
		
		JLabel label_34 = new JLabel("");
		label_34.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0015_4.png")));
		label_34.setBounds(395, 559, 71, 76);
		module1Part1TakeQuiz3.add(label_34);
		
		JLabel label_35 = new JLabel("");
		label_35.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0014_5.png")));
		label_35.setBounds(475, 559, 71, 76);
		module1Part1TakeQuiz3.add(label_35);
		
		JLabel label_36 = new JLabel();
		label_36.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		label_36.setBounds(0, 670, 1280, 21);
		module1Part1TakeQuiz3.add(label_36);
		
		JLabel label_37 = new JLabel("");
		label_37.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/grey_background.png")));
		label_37.setBounds(0, 0, 1280, 691);
		module1Part1TakeQuiz3.add(label_37);
	}
	
	private void initialize_module1part4(JFrame frame){
		module1Part1TakeQuiz4 = new JPanel();
		module1Part1TakeQuiz4.setLayout(null);
		module1Part1TakeQuiz4.setForeground(Color.WHITE);
		module1Part1TakeQuiz4.setBackground(Color.WHITE);
		frame.getContentPane().add(module1Part1TakeQuiz4, "name_12291838406804");
		
		JLabel label_38 = new JLabel("");
		label_38.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0004_book.png")));
		label_38.setBounds(150, 128, 223, 195);
		module1Part1TakeQuiz4.add(label_38);
		
		JLabel label_39 = new JLabel("");
		label_39.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0003_carrot.png")));
		label_39.setBounds(524, 128, 223, 195);
		module1Part1TakeQuiz4.add(label_39);
		
		JLabel label_40 = new JLabel("");
		label_40.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0003_scissors.png")));
		label_40.setBounds(898, 128, 223, 195);
		module1Part1TakeQuiz4.add(label_40);
		
		JLabel label_41 = new JLabel("");
		label_41.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/scissors_sign.png")));
		label_41.setBounds(950, 352, 153, 116);
		module1Part1TakeQuiz4.add(label_41);
		
		JLabel label_42 = new JLabel("");
		label_42.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Carrot.png")));
		label_42.setBounds(601, 352, 71, 169);
		module1Part1TakeQuiz4.add(label_42);
		
		JLabel label_43 = new JLabel("");
		label_43.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/book_sign.png")));
		label_43.setBounds(184, 352, 157, 134);
		module1Part1TakeQuiz4.add(label_43);
		
		JLabel label_44 = new JLabel("");
		label_44.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0002_Sign-the-word-that-does-not-belong-to-the-group.png")));
		label_44.setBounds(103, 29, 1067, 49);
		module1Part1TakeQuiz4.add(label_44);
		
		JLabel label_45 = new JLabel("");
		label_45.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Passive.png")));
		label_45.setBounds(27, 550, 98, 96);
		module1Part1TakeQuiz4.add(label_45);
		
		JLabel label_46 = new JLabel("");
		label_46.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0011_3.png")));
		label_46.setBounds(312, 559, 71, 76);
		module1Part1TakeQuiz4.add(label_46);
		
		JLabel label_47 = new JLabel("");
		label_47.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0012_2.png")));
		label_47.setBounds(231, 559, 71, 76);
		module1Part1TakeQuiz4.add(label_47);
		
		JLabel label_48 = new JLabel("");
		label_48.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0013_1.png")));
		label_48.setBounds(150, 559, 71, 76);
		module1Part1TakeQuiz4.add(label_48);
		
		JLabel label_49 = new JLabel("");
		label_49.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0010_4.png")));
		label_49.setBounds(395, 559, 71, 76);
		module1Part1TakeQuiz4.add(label_49);
		
		JLabel label_50 = new JLabel("");
		label_50.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0014_5.png")));
		label_50.setBounds(475, 559, 71, 76);
		module1Part1TakeQuiz4.add(label_50);
		
		JLabel label_51 = new JLabel();
		label_51.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		label_51.setBounds(0, 670, 1280, 21);
		module1Part1TakeQuiz4.add(label_51);
		
		JLabel label_52 = new JLabel("");
		label_52.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/grey_background.png")));
		label_52.setBounds(0, 0, 1280, 691);
		module1Part1TakeQuiz4.add(label_52);
	}
	
	private void initialize_module1part5(JFrame frame){
		module1Part1TakeQuiz5 = new JPanel();
		module1Part1TakeQuiz5.setLayout(null);
		module1Part1TakeQuiz5.setForeground(Color.WHITE);
		module1Part1TakeQuiz5.setBackground(Color.WHITE);
		frame.getContentPane().add(module1Part1TakeQuiz5, "name_12905908214761");
		
		JLabel label_53 = new JLabel("");
		label_53.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0005_bed.png")));
		label_53.setBounds(150, 128, 223, 195);
		module1Part1TakeQuiz5.add(label_53);
		
		JLabel label_54 = new JLabel("");
		label_54.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0004_pillow.png")));
		label_54.setBounds(524, 128, 223, 195);
		module1Part1TakeQuiz5.add(label_54);
		
		JLabel label_55 = new JLabel("");
		label_55.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0003_pencil.png")));
		label_55.setBounds(898, 128, 223, 195);
		module1Part1TakeQuiz5.add(label_55);
		
		JLabel label_56 = new JLabel("");
		label_56.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/pencil_sign.png")));
		label_56.setBounds(964, 352, 108, 134);
		module1Part1TakeQuiz5.add(label_56);
		
		JLabel label_57 = new JLabel("");
		label_57.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/pillow_sign.png")));
		label_57.setBounds(596, 352, 98, 134);
		module1Part1TakeQuiz5.add(label_57);
		
		JLabel label_58 = new JLabel("");
		label_58.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/bed_sign.png")));
		label_58.setBounds(194, 352, 137, 134);
		module1Part1TakeQuiz5.add(label_58);
		
		JLabel label_59 = new JLabel("");
		label_59.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0002_Sign-the-word-that-does-not-belong-to-the-group.png")));
		label_59.setBounds(103, 29, 1067, 49);
		module1Part1TakeQuiz5.add(label_59);
		
		JLabel label_60 = new JLabel("");
		label_60.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Passive.png")));
		label_60.setBounds(27, 550, 98, 96);
		module1Part1TakeQuiz5.add(label_60);
		
		JLabel label_61 = new JLabel("");
		label_61.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0011_3.png")));
		label_61.setBounds(312, 559, 71, 76);
		module1Part1TakeQuiz5.add(label_61);
		
		JLabel label_62 = new JLabel("");
		label_62.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0012_2.png")));
		label_62.setBounds(231, 559, 71, 76);
		module1Part1TakeQuiz5.add(label_62);
		
		JLabel label_63 = new JLabel("");
		label_63.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0013_1.png")));
		label_63.setBounds(150, 559, 71, 76);
		module1Part1TakeQuiz5.add(label_63);
		
		JLabel label_64 = new JLabel("");
		label_64.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0010_4.png")));
		label_64.setBounds(395, 559, 71, 76);
		module1Part1TakeQuiz5.add(label_64);
		
		JLabel label_65 = new JLabel("");
		label_65.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0009_5.png")));
		label_65.setBounds(475, 559, 71, 76);
		module1Part1TakeQuiz5.add(label_65);
		
		JLabel label_66 = new JLabel();
		label_66.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		label_66.setBounds(0, 670, 1280, 21);
		module1Part1TakeQuiz5.add(label_66);
		
		JLabel label_67 = new JLabel("");
		label_67.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/grey_background.png")));
		label_67.setBounds(0, 0, 1280, 691);
		module1Part1TakeQuiz5.add(label_67);
		
		module1Part2TakeQuiz1 = new JPanel();
		module1Part2TakeQuiz1.setLayout(null);
		module1Part2TakeQuiz1.setForeground(Color.WHITE);
		module1Part2TakeQuiz1.setBackground(Color.WHITE);
		frame.getContentPane().add(module1Part2TakeQuiz1, "name_37109032450282");
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/_0004_beach_image.png")));
		lblNewLabel_5.setBounds(89, 129, 472, 353);
		module1Part2TakeQuiz1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/at_the_school.png")));
		lblNewLabel_6.setBounds(634, 164, 393, 76);
		module1Part2TakeQuiz1.add(lblNewLabel_6);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/at_the_beach.png")));
		label_1.setBounds(634, 371, 393, 76);
		module1Part2TakeQuiz1.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/at_the_playground.png")));
		label.setBounds(634, 270, 503, 76);
		module1Part2TakeQuiz1.add(label);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/_0003_Sign-the-letter-of-the-correct-title-of-the-picture.png")));
		label_6.setBounds(103, 29, 1067, 49);
		module1Part2TakeQuiz1.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Passive.png")));
		label_7.setBounds(27, 550, 98, 96);
		module1Part2TakeQuiz1.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0016_3.png")));
		label_8.setBounds(312, 559, 71, 76);
		module1Part2TakeQuiz1.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0017_2.png")));
		label_9.setBounds(231, 559, 71, 76);
		module1Part2TakeQuiz1.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0013_1.png")));
		label_10.setBounds(150, 559, 71, 76);
		module1Part2TakeQuiz1.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0015_4.png")));
		label_11.setBounds(395, 559, 71, 76);
		module1Part2TakeQuiz1.add(label_11);
		
		JLabel label_13 = new JLabel();
		label_13.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		label_13.setBounds(0, 670, 1280, 21);
		module1Part2TakeQuiz1.add(label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/grey_background.png")));
		label_14.setBounds(0, 0, 1280, 691);
		module1Part2TakeQuiz1.add(label_14);
		
		JPanel module1Part2TakeQuiz2 = new JPanel();
		module1Part2TakeQuiz2.setLayout(null);
		module1Part2TakeQuiz2.setForeground(Color.WHITE);
		module1Part2TakeQuiz2.setBackground(Color.WHITE);
		frame.getContentPane().add(module1Part2TakeQuiz2, "name_48708576472898");
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/_0003_sick_boy.png")));
		label_2.setBounds(89, 129, 472, 353);
		module1Part2TakeQuiz2.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/the_happy_boy.png")));
		label_3.setBounds(634, 164, 472, 76);
		module1Part2TakeQuiz2.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/the_angry_boy.png")));
		label_4.setBounds(634, 371, 472, 76);
		module1Part2TakeQuiz2.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/the_sick_boy.png")));
		label_5.setBounds(634, 270, 503, 76);
		module1Part2TakeQuiz2.add(label_5);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/_0003_Sign-the-letter-of-the-correct-title-of-the-picture.png")));
		label_12.setBounds(103, 29, 1067, 49);
		module1Part2TakeQuiz2.add(label_12);
		
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Passive.png")));
		label_15.setBounds(27, 550, 98, 96);
		module1Part2TakeQuiz2.add(label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0016_3.png")));
		label_16.setBounds(312, 559, 71, 76);
		module1Part2TakeQuiz2.add(label_16);
		
		JLabel label_17 = new JLabel("");
		label_17.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0012_2.png")));
		label_17.setBounds(231, 559, 71, 76);
		module1Part2TakeQuiz2.add(label_17);
		
		JLabel label_18 = new JLabel("");
		label_18.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0013_1.png")));
		label_18.setBounds(150, 559, 71, 76);
		module1Part2TakeQuiz2.add(label_18);
		
		JLabel label_19 = new JLabel("");
		label_19.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0015_4.png")));
		label_19.setBounds(395, 559, 71, 76);
		module1Part2TakeQuiz2.add(label_19);
		
		JLabel label_20 = new JLabel();
		label_20.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		label_20.setBounds(0, 670, 1280, 21);
		module1Part2TakeQuiz2.add(label_20);
		
		JLabel label_21 = new JLabel("");
		label_21.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/grey_background.png")));
		label_21.setBounds(0, 0, 1280, 691);
		module1Part2TakeQuiz2.add(label_21);
		
		JPanel module1Part2TakeQuiz3 = new JPanel();
		module1Part2TakeQuiz3.setLayout(null);
		module1Part2TakeQuiz3.setForeground(Color.WHITE);
		module1Part2TakeQuiz3.setBackground(Color.WHITE);
		frame.getContentPane().add(module1Part2TakeQuiz3, "name_48982021921946");
		
		JLabel label_22 = new JLabel("");
		label_22.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/_0003_teacher.png")));
		label_22.setBounds(89, 129, 472, 353);
		module1Part2TakeQuiz3.add(label_22);
		
		JLabel label_23 = new JLabel("");
		label_23.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/at_the_school.png")));
		label_23.setBounds(634, 164, 472, 76);
		module1Part2TakeQuiz3.add(label_23);
		
		JLabel label_24 = new JLabel("");
		label_24.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/at_the_market.png")));
		label_24.setBounds(634, 371, 472, 76);
		module1Part2TakeQuiz3.add(label_24);
		
		JLabel label_25 = new JLabel("");
		label_25.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/at_the_chruch.png")));
		label_25.setBounds(634, 270, 503, 76);
		module1Part2TakeQuiz3.add(label_25);
		
		JLabel label_26 = new JLabel("");
		label_26.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/_0003_Sign-the-letter-of-the-correct-title-of-the-picture.png")));
		label_26.setBounds(103, 29, 1067, 49);
		module1Part2TakeQuiz3.add(label_26);
		
		JLabel label_27 = new JLabel("");
		label_27.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Passive.png")));
		label_27.setBounds(27, 550, 98, 96);
		module1Part2TakeQuiz3.add(label_27);
		
		JLabel label_28 = new JLabel("");
		label_28.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0011_3.png")));
		label_28.setBounds(312, 559, 71, 76);
		module1Part2TakeQuiz3.add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0012_2.png")));
		label_29.setBounds(231, 559, 71, 76);
		module1Part2TakeQuiz3.add(label_29);
		
		JLabel label_30 = new JLabel("");
		label_30.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0013_1.png")));
		label_30.setBounds(150, 559, 71, 76);
		module1Part2TakeQuiz3.add(label_30);
		
		JLabel label_31 = new JLabel("");
		label_31.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0015_4.png")));
		label_31.setBounds(395, 559, 71, 76);
		module1Part2TakeQuiz3.add(label_31);
		
		JLabel label_32 = new JLabel();
		label_32.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		label_32.setBounds(0, 670, 1280, 21);
		module1Part2TakeQuiz3.add(label_32);
		
		JLabel label_33 = new JLabel("");
		label_33.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/grey_background.png")));
		label_33.setBounds(0, 0, 1280, 691);
		module1Part2TakeQuiz3.add(label_33);
		
		JPanel module1Part2TakeQuiz4 = new JPanel();
		module1Part2TakeQuiz4.setLayout(null);
		module1Part2TakeQuiz4.setForeground(Color.WHITE);
		module1Part2TakeQuiz4.setBackground(Color.WHITE);
		frame.getContentPane().add(module1Part2TakeQuiz4, "name_49178325719742");
		
		JLabel label_34 = new JLabel("");
		label_34.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/_0003_helpful.png")));
		label_34.setBounds(89, 129, 472, 353);
		module1Part2TakeQuiz4.add(label_34);
		
		JLabel label_35 = new JLabel("");
		label_35.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/lazy_child.png")));
		label_35.setBounds(634, 164, 472, 76);
		module1Part2TakeQuiz4.add(label_35);
		
		JLabel label_36 = new JLabel("");
		label_36.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/sleepy_child.png")));
		label_36.setBounds(634, 371, 472, 76);
		module1Part2TakeQuiz4.add(label_36);
		
		JLabel label_37 = new JLabel("");
		label_37.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/helpful_child.png")));
		label_37.setBounds(634, 270, 503, 76);
		module1Part2TakeQuiz4.add(label_37);
		
		JLabel label_38 = new JLabel("");
		label_38.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part2/_0003_Sign-the-letter-of-the-correct-title-of-the-picture.png")));
		label_38.setBounds(103, 29, 1067, 49);
		module1Part2TakeQuiz4.add(label_38);
		
		JLabel label_39 = new JLabel("");
		label_39.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Passive.png")));
		label_39.setBounds(27, 550, 98, 96);
		module1Part2TakeQuiz4.add(label_39);
		
		JLabel label_40 = new JLabel("");
		label_40.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0011_3.png")));
		label_40.setBounds(312, 559, 71, 76);
		module1Part2TakeQuiz4.add(label_40);
		
		JLabel label_41 = new JLabel("");
		label_41.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0012_2.png")));
		label_41.setBounds(231, 559, 71, 76);
		module1Part2TakeQuiz4.add(label_41);
		
		JLabel label_42 = new JLabel("");
		label_42.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0013_1.png")));
		label_42.setBounds(150, 559, 71, 76);
		module1Part2TakeQuiz4.add(label_42);
		
		JLabel label_43 = new JLabel("");
		label_43.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0010_4.png")));
		label_43.setBounds(395, 559, 71, 76);
		module1Part2TakeQuiz4.add(label_43);
		
		JLabel label_44 = new JLabel();
		label_44.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		label_44.setBounds(0, 670, 1280, 21);
		module1Part2TakeQuiz4.add(label_44);
		
		JLabel label_45 = new JLabel("");
		label_45.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/grey_background.png")));
		label_45.setBounds(0, 0, 1280, 691);
		module1Part2TakeQuiz4.add(label_45);
		
		JPanel module1Part3TakeQuiz1 = new JPanel();
		module1Part3TakeQuiz1.setLayout(null);
		module1Part3TakeQuiz1.setForeground(Color.WHITE);
		module1Part3TakeQuiz1.setBackground(Color.WHITE);
		frame.getContentPane().add(module1Part3TakeQuiz1, "name_2085382424721");
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/play.png")));
		lblNewLabel_7.setBounds(152, 190, 200, 236);
		module1Part3TakeQuiz1.add(lblNewLabel_7);
		
		JLabel label_46 = new JLabel("");
		label_46.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/christmas.png")));
		label_46.setBounds(504, 190, 232, 236);
		module1Part3TakeQuiz1.add(label_46);
		
		JLabel label_47 = new JLabel("");
		label_47.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/new year.png")));
		label_47.setBounds(888, 190, 234, 236);
		module1Part3TakeQuiz1.add(label_47);
		
		JLabel label_50 = new JLabel("");
		label_50.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/Sign-the-letter-that-is-NOT-about-the-given-topic.png")));
		label_50.setBounds(103, 29, 1067, 49);
		module1Part3TakeQuiz1.add(label_50);
		
		JLabel label_51 = new JLabel("");
		label_51.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Passive.png")));
		label_51.setBounds(27, 550, 98, 96);
		module1Part3TakeQuiz1.add(label_51);
		
		JLabel label_70 = new JLabel("");
		label_70.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0015_4.png")));
		label_70.setBounds(395, 559, 71, 76);
		module1Part3TakeQuiz1.add(label_70);
		
		JLabel label_52 = new JLabel("");
		label_52.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0016_3.png")));
		label_52.setBounds(312, 559, 71, 76);
		module1Part3TakeQuiz1.add(label_52);
		
		JLabel label_68 = new JLabel("");
		label_68.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0017_2.png")));
		label_68.setBounds(231, 559, 71, 76);
		module1Part3TakeQuiz1.add(label_68);
		
		JLabel label_69 = new JLabel("");
		label_69.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0013_1.png")));
		label_69.setBounds(150, 559, 71, 76);
		module1Part3TakeQuiz1.add(label_69);
		
		JLabel label_71 = new JLabel();
		label_71.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		label_71.setBounds(0, 670, 1280, 21);
		module1Part3TakeQuiz1.add(label_71);
		
		JLabel label_72 = new JLabel("");
		label_72.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/grey_background.png")));
		label_72.setBounds(0, 0, 1280, 691);
		module1Part3TakeQuiz1.add(label_72);
		
		JPanel module1Part3TakeQuiz2 = new JPanel();
		module1Part3TakeQuiz2.setLayout(null);
		module1Part3TakeQuiz2.setForeground(Color.WHITE);
		module1Part3TakeQuiz2.setBackground(Color.WHITE);
		frame.getContentPane().add(module1Part3TakeQuiz2, "name_2624620722215");
		
		JLabel label_48 = new JLabel("");
		label_48.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/shoot a bird.png")));
		label_48.setBounds(88, 190, 296, 236);
		module1Part3TakeQuiz2.add(label_48);
		
		JLabel label_49 = new JLabel("");
		label_49.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/feed the chicken.png")));
		label_49.setBounds(472, 190, 330, 236);
		module1Part3TakeQuiz2.add(label_49);
		
		JLabel label_73 = new JLabel("");
		label_73.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/bath the dog.png")));
		label_73.setBounds(890, 190, 296, 236);
		module1Part3TakeQuiz2.add(label_73);
		
		JLabel label_74 = new JLabel("");
		label_74.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/Sign-the-letter-that-is-NOT-about-the-given-topic.png")));
		label_74.setBounds(103, 29, 1067, 49);
		module1Part3TakeQuiz2.add(label_74);
		
		JLabel label_75 = new JLabel("");
		label_75.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Passive.png")));
		label_75.setBounds(27, 550, 98, 96);
		module1Part3TakeQuiz2.add(label_75);
		
		JLabel label_76 = new JLabel("");
		label_76.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0015_4.png")));
		label_76.setBounds(395, 559, 71, 76);
		module1Part3TakeQuiz2.add(label_76);
		
		JLabel label_77 = new JLabel("");
		label_77.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0016_3.png")));
		label_77.setBounds(312, 559, 71, 76);
		module1Part3TakeQuiz2.add(label_77);
		
		JLabel label_78 = new JLabel("");
		label_78.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0012_2.png")));
		label_78.setBounds(231, 559, 71, 76);
		module1Part3TakeQuiz2.add(label_78);
		
		JLabel label_79 = new JLabel("");
		label_79.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0013_1.png")));
		label_79.setBounds(150, 559, 71, 76);
		module1Part3TakeQuiz2.add(label_79);
		
		JLabel label_80 = new JLabel();
		label_80.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		label_80.setBounds(0, 670, 1280, 21);
		module1Part3TakeQuiz2.add(label_80);
		
		JLabel label_81 = new JLabel("");
		label_81.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/grey_background.png")));
		label_81.setBounds(0, 0, 1280, 691);
		module1Part3TakeQuiz2.add(label_81);
		
		JPanel module1Part3TakeQuiz3 = new JPanel();
		module1Part3TakeQuiz3.setLayout(null);
		module1Part3TakeQuiz3.setForeground(Color.WHITE);
		module1Part3TakeQuiz3.setBackground(Color.WHITE);
		frame.getContentPane().add(module1Part3TakeQuiz3, "name_3032036186208");
		
		JLabel label_82 = new JLabel("");
		label_82.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/watch tv.png")));
		label_82.setBounds(133, 190, 235, 236);
		module1Part3TakeQuiz3.add(label_82);
		
		JLabel label_83 = new JLabel("");
		label_83.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/play1.png")));
		label_83.setBounds(501, 190, 200, 236);
		module1Part3TakeQuiz3.add(label_83);
		
		JLabel label_84 = new JLabel("");
		label_84.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/eat breakfast.png")));
		label_84.setBounds(834, 190, 307, 236);
		module1Part3TakeQuiz3.add(label_84);
		
		JLabel label_85 = new JLabel("");
		label_85.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/Sign-the-letter-that-is-NOT-about-the-given-topic.png")));
		label_85.setBounds(103, 29, 1067, 49);
		module1Part3TakeQuiz3.add(label_85);
		
		JLabel label_86 = new JLabel("");
		label_86.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Passive.png")));
		label_86.setBounds(27, 550, 98, 96);
		module1Part3TakeQuiz3.add(label_86);
		
		JLabel label_87 = new JLabel("");
		label_87.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0015_4.png")));
		label_87.setBounds(395, 559, 71, 76);
		module1Part3TakeQuiz3.add(label_87);
		
		JLabel label_88 = new JLabel("");
		label_88.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0011_3.png")));
		label_88.setBounds(312, 559, 71, 76);
		module1Part3TakeQuiz3.add(label_88);
		
		JLabel label_89 = new JLabel("");
		label_89.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0012_2.png")));
		label_89.setBounds(231, 559, 71, 76);
		module1Part3TakeQuiz3.add(label_89);
		
		JLabel label_90 = new JLabel("");
		label_90.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0013_1.png")));
		label_90.setBounds(150, 559, 71, 76);
		module1Part3TakeQuiz3.add(label_90);
		
		JLabel label_91 = new JLabel();
		label_91.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		label_91.setBounds(0, 670, 1280, 21);
		module1Part3TakeQuiz3.add(label_91);
		
		JLabel label_92 = new JLabel("");
		label_92.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/grey_background.png")));
		label_92.setBounds(0, 0, 1280, 691);
		module1Part3TakeQuiz3.add(label_92);
		
		JPanel module1Part3TakeQuiz4 = new JPanel();
		module1Part3TakeQuiz4.setLayout(null);
		module1Part3TakeQuiz4.setForeground(Color.WHITE);
		module1Part3TakeQuiz4.setBackground(Color.WHITE);
		frame.getContentPane().add(module1Part3TakeQuiz4, "name_3337476284846");
		
		JLabel label_93 = new JLabel("");
		label_93.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/eat junk food.png")));
		label_93.setBounds(124, 190, 307, 236);
		module1Part3TakeQuiz4.add(label_93);
		
		JLabel label_94 = new JLabel("");
		label_94.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/excercise.png")));
		label_94.setBounds(555, 190, 234, 236);
		module1Part3TakeQuiz4.add(label_94);
		
		JLabel label_95 = new JLabel("");
		label_95.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/drink milk.png")));
		label_95.setBounds(913, 190, 234, 236);
		module1Part3TakeQuiz4.add(label_95);
		
		JLabel label_96 = new JLabel("");
		label_96.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part3/Sign-the-letter-that-is-NOT-about-the-given-topic.png")));
		label_96.setBounds(103, 29, 1067, 49);
		module1Part3TakeQuiz4.add(label_96);
		
		JLabel label_97 = new JLabel("");
		label_97.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0001_Passive.png")));
		label_97.setBounds(27, 550, 98, 96);
		module1Part3TakeQuiz4.add(label_97);
		
		JLabel label_98 = new JLabel("");
		label_98.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0010_4.png")));
		label_98.setBounds(395, 559, 71, 76);
		module1Part3TakeQuiz4.add(label_98);
		
		JLabel label_99 = new JLabel("");
		label_99.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0011_3.png")));
		label_99.setBounds(312, 559, 71, 76);
		module1Part3TakeQuiz4.add(label_99);
		
		JLabel label_100 = new JLabel("");
		label_100.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0012_2.png")));
		label_100.setBounds(231, 559, 71, 76);
		module1Part3TakeQuiz4.add(label_100);
		
		JLabel label_101 = new JLabel("");
		label_101.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/module1part1/_0013_1.png")));
		label_101.setBounds(150, 559, 71, 76);
		module1Part3TakeQuiz4.add(label_101);
		
		JLabel label_102 = new JLabel();
		label_102.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/footer_bar_v2.png")));
		label_102.setBounds(0, 670, 1280, 21);
		module1Part3TakeQuiz4.add(label_102);
		
		JLabel label_103 = new JLabel("");
		label_103.setIcon(new ImageIcon(MainDashboard.class.getResource("/assets/img/grey_background.png")));
		label_103.setBounds(0, 0, 1280, 691);
		module1Part3TakeQuiz4.add(label_103);
	}
}
