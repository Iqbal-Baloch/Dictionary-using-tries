package MainApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JPopupMenu;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import java.awt.Insets;
import java.awt.Canvas;
import java.awt.Panel;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import org.apache.commons.lang3.*;
import javax.swing.JFormattedTextField;
import java.awt.ComponentOrientation;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;;


public class MainInterFace {
	public Trie loadDict()
	{
		BufferedReader br ;
		Trie t = new Trie() ;
		try
		{
			InputStreamReader isr = new InputStreamReader(new FileInputStream("text2.txt" ), "UTF-8");
			br = new BufferedReader(isr) ;
			String line = br.readLine() ;
			
			while(line != null)
			{
				line = org.apache.commons.lang3.StringEscapeUtils.unescapeJava(line);

				String token[] =  line.split("^\\S+") ;
				String token1[] = line.split("\\W+") ;
				if(token.length>=2 && token1.length >= 1) 
				{
					String row[] = {token1[0] , token[1]} ;
					t.insert(token1[0] , token[1]);
					model.addRow(row);
				}  
				
				line = br.readLine() ;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return t ;
	}
	private JFrame HomeFrame;
	private JTextField SearchText;
	private Trie dict ;
	private JTable table_1;
	private DefaultTableModel model;
	private JLabel autoRes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterFace window = new MainInterFace();
					window.HomeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainInterFace() {
		initialize();
		dict = loadDict() ;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		HomeFrame = new JFrame();
		HomeFrame.setResizable(false);
		HomeFrame.getContentPane().setBackground(new Color(51, 102, 102));
		
		JPanel SerchButton = new JPanel();
		SerchButton.setBackground(SystemColor.activeCaptionBorder);
		
		JPanel LogoPanal = new JPanel();
		LogoPanal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LogoPanal.setBackground(new Color(90, 102, 102));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LogoPanal.setBackground(new Color(51, 102, 102));
			}
		});
		LogoPanal.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		LogoPanal.setBackground(new Color(51, 102, 102));
		
		JTextPane resultText = new JTextPane();
		resultText.setEditable(false);
		resultText.setBackground(SystemColor.controlText);
		resultText.setForeground(SystemColor.textHighlightText);
		resultText.setFont(new Font("Gadugi", Font.PLAIN, 18));
		resultText.setText("Search Result");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(HomeFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(LogoPanal, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(resultText, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(SerchButton, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(SerchButton, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(resultText, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
						.addComponent(LogoPanal, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		
		table_1 = new JTable();
		table_1.setIntercellSpacing(new Dimension(20, 100));
		table_1.setGridColor(SystemColor.textHighlightText);
		table_1.setRowMargin(0);
		table_1.setRowHeight(30);
		table_1.setForeground(SystemColor.inactiveCaptionText);
		table_1.setFont(new Font("Arial Unicode MS", Font.BOLD, 13));
		table_1.setEnabled(false);
		table_1.setBackground(Color.LIGHT_GRAY);
		model = new DefaultTableModel() ;
		Object[] column = {"Word  (  الفاظ  )", "Meaning  ( مطلب / معنی)"} ;
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);
		
		JButton SearchButton = new JButton("Search");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String find = SearchText.getText() ;
				resultText.setText(dict.search(find));
			}
		});
		SearchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				SearchButton.setBackground(new Color(51, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				SearchButton.setBackground(new Color(255, 51, 51));
			}
		});
		SearchButton.setToolTipText("Search a medican in dicnery\r\n");
		SearchButton.setBackground(new Color(255, 51, 51));
		SearchButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		SearchText = new JTextField();
		
		SearchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ArrayList a = dict.autoComplete(SearchText.getText()) ;
				autoRes.setText(a.toString());
			}
		});
		SearchText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String find = SearchText.getText() ;
				resultText.setText(dict.search(find));
			}
		});
		SearchText.setFont(new Font("Tahoma", Font.BOLD, 14));
		SearchText.setColumns(10);
		
		autoRes = new JLabel();
		autoRes.setText("hello");
		GroupLayout gl_SerchButton = new GroupLayout(SerchButton);
		gl_SerchButton.setHorizontalGroup(
			gl_SerchButton.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_SerchButton.createSequentialGroup()
					.addGroup(gl_SerchButton.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_SerchButton.createSequentialGroup()
							.addContainerGap()
							.addComponent(autoRes, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
						.addGroup(gl_SerchButton.createSequentialGroup()
							.addGap(30)
							.addComponent(SearchText, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(SearchButton, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))
					.addGap(18))
		);
		gl_SerchButton.setVerticalGroup(
			gl_SerchButton.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SerchButton.createSequentialGroup()
					.addGroup(gl_SerchButton.createParallelGroup(Alignment.BASELINE)
						.addComponent(SearchText, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(SearchButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(autoRes, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
					.addContainerGap())
		);
		SerchButton.setLayout(gl_SerchButton);
		
		JLabel logo = new JLabel("");
		
		logo.setIcon(new ImageIcon("image.png"));
		GroupLayout gl_LogoPanal = new GroupLayout(LogoPanal);
		gl_LogoPanal.setHorizontalGroup(
			gl_LogoPanal.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_LogoPanal.createSequentialGroup()
					.addContainerGap()
					.addComponent(logo, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_LogoPanal.setVerticalGroup(
			gl_LogoPanal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LogoPanal.createSequentialGroup()
					.addComponent(logo, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addContainerGap())
		);
		LogoPanal.setLayout(gl_LogoPanal);
		HomeFrame.getContentPane().setLayout(groupLayout);
		HomeFrame.setBackground(new Color(255, 0, 0));
		HomeFrame.setTitle("English to Urdu Dictonary");
		HomeFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("logo copy.png"));
		HomeFrame.setBounds(100, 100, 746, 596);
		HomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		HomeFrame.setJMenuBar(menuBar);
		
		JSeparator TopMenue = new JSeparator();
		TopMenue.setOrientation(SwingConstants.VERTICAL);
		TopMenue.setForeground(new Color(255, 0, 0));
		TopMenue.setBackground(new Color(255, 0, 0));
		menuBar.add(TopMenue);
		// Exit Button click to Exit
		
		
		JButton exit = new JButton("    Exit  ");
		exit.addActionListener(new ActionListener() // interface ActionListener implementation(Action when button pressed)
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0); // Exit the program with exit code 0.
			}
		});
		// Mouse enter and exit effect
		exit.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseEntered(MouseEvent e) // mouse enter 
			{
				exit.setBackground(new Color(255, 51, 51));
			}
			@Override
			public void mouseExited(MouseEvent e) // mouse exit
			{
				exit.setBackground(SystemColor.textHighlight);
			}
		});
		exit.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		exit.setBackground(SystemColor.textHighlight);
		exit.setForeground(new Color(0, 51, 102));
		exit.setToolTipText("Click this to exit\r\n");
		menuBar.add(exit);
	}
}
