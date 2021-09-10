import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URI;

/* 
 * Boeing 737-800 take off speed calculator
 * 
 * author	komed3 (Paul Koehler)
 * web		https://labs.komed3.de
 * date		2021-06-30
 * version	1.02
 * license	MIT
 * code		https://github.com/komed3/tos-737-800/
 * 
 * Do not use for real life flight!
 * Valid for flight simulation use only!
 * 
 */

public class top extends JFrame {
	
	// take off preference tables
	
	static String[] flpsPos = { "1", "5", "15" };
	
	static int[][] pref = {
		{  0,  0,  0,  1,  2,  3,  4 },
		{  0,  0,  0,  1,  2,  3,  4 },
		{  0,  0,  0,  1,  2,  3,  4 },
		{  0,  0,  0,  1,  2,  4, -1 },
		{  0,  0,  1,  1,  3,  4, -1 },
		{  1,  1,  1,  2,  3,  4, -1 },
		{  1,  1,  1,  2,  3,  4, -1 },
		{  1,  1,  2,  3,  4, -1, -1 },
		{  2,  2,  2,  3,  4, -1, -1 },
		{  2,  2,  3,  3,  4, -1, -1 }
	};
	
	static int[][][] v1 = {
		{
			{  -1,  -1,  -1,  -1,  -1,  -1, 108, 118, 128, 138, 146, 154, 161 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 104, 114, 122, 131, 138, 146, 154 },
			{  -1,  -1,  -1,  -1,  -1,  -1,  99, 108, 116, 124, 132, 140,  -1 }
		}, {
			{  -1,  -1,  -1,  -1,  -1,  -1, 110, 120, 130, 140, 147, 155, 162 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 106, 115, 124, 132, 141, 148, 155 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 100, 109, 117, 125, 134, 141,  -1 }
		}, {
			{  -1,  -1,  -1,  -1,  -1,  -1, 111, 222, 132, 141, 149, 156,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 107, 116, 125, 134, 141, 148,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 101, 110, 118, 127, 135, 142,  -1 }
		}, {
			{  -1,  -1,  -1,  -1,  -1,  -1, 113, 123, 133, 143,  -1,  -1,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 108, 117, 126, 133, 142,  -1,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 103, 111, 120, 128, 136,  -1,  -1 }
		}, {
			{  -1,  -1,  -1,  -1,  -1,  -1, 115, 125,  -1,  -1,  -1,  -1,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 109, 119, 128,  -1,  -1,  -1,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 104, 113, 122,  -1,  -1,  -1,  -1 }
		}
	};
	
	static int[][][] vr = {
		{
			{  -1,  -1,  -1,  -1,  -1,  -1, 108, 118, 128, 138, 147, 155, 163 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 104, 114, 122, 131, 139, 147, 155 },
			{  -1,  -1,  -1,  -1,  -1,  -1,  99, 108, 116, 124, 132, 140,  -1 }
		}, {
			{  -1,  -1,  -1,  -1,  -1,  -1, 110, 120, 130, 140, 148, 156, 164 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 106, 115, 124, 132, 141, 149, 156 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 100, 109, 117, 125, 134, 141,  -1 }
		}, {
			{  -1,  -1,  -1,  -1,  -1,  -1, 111, 122, 132, 141, 150, 157,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 107, 116, 125, 134, 142, 150,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 101, 110, 118, 127, 135, 142,  -1 }
		}, {
			{  -1,  -1,  -1,  -1,  -1,  -1, 113, 123, 133, 143,  -1,  -1,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 108, 117, 126, 135, 143,  -1,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 103, 111, 120, 128, 136,  -1,  -1 }
		}, {
			{  -1,  -1,  -1,  -1,  -1,  -1, 115, 125,  -1,  -1,  -1,  -1,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 109, 119, 128,  -1,  -1,  -1,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 104, 113, 122,  -1,  -1,  -1,  -1 }
		}
	};
	
	static int[][][] v2 = {
		{
			{  -1,  -1,  -1,  -1,  -1,  -1, 122, 130, 138, 147, 154, 161, 167 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 118, 125, 132, 139, 146, 153, 159 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 112, 119, 126, 132, 139, 145,  -1 }
		}, {
			{  -1,  -1,  -1,  -1,  -1,  -1, 122, 130, 138, 147, 154, 161, 167 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 118, 125, 132, 139, 146, 153, 160 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 112, 119, 125, 132, 139, 145,  -1 }
		}, {
			{  -1,  -1,  -1,  -1,  -1,  -1, 121, 130, 138, 147, 154, 161,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 117, 124, 131, 139, 146, 153,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 111, 118, 125, 132, 139, 145,  -1 }
		}, {
			{  -1,  -1,  -1,  -1,  -1,  -1, 121, 130, 138, 147,  -1,  -1,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 117, 124, 131, 139, 146,  -1,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 111, 118, 125, 132, 139,  -1,  -1 }
		}, {
			{  -1,  -1,  -1,  -1,  -1,  -1, 121, 130,  -1,  -1,  -1,  -1,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 116, 124, 131,  -1,  -1,  -1,  -1 },
			{  -1,  -1,  -1,  -1,  -1,  -1, 110, 117, 125,  -1,  -1,  -1,  -1 }
		}
	};
	
	static int[][] v1reduc = {
		{  0,  0, 14, 10,  8,  6,  5,  4 },
		{  0,  0, 14, 10,  8,  6,  5,  4 },
		{  0,  0, 12,  8,  6,  4,  3,  2 }
	};
	
	// input/output fields
	
	static JSpinner[] spinner = new JSpinner[5];
	static JComboBox[] combos = new JComboBox[1];
	static JCheckBox[] checks = new JCheckBox[1];
	
	static JTextField[] speeds = new JTextField[3];
	
	static ImageIcon fico;
	
    // help dialog
    
    private static void helpdesk() {
        
        JFrame helpf = new JFrame();
		
		helpf.setLayout( new BorderLayout() );
        
        JPanel help1 = new JPanel();
		help1.setLayout( new GridLayout( 0, 2, 10, 10 ) );
		help1.setBorder( new EmptyBorder( 20, 20, 10, 20 ) );
        
        help1.add( new JLabel( "<html><b>V<sub>1</sub></b></html>" ) );
        help1.add( new JLabel( "maximum speed up to which a start abort may be initiated" ) );
        help1.add( new JLabel( "<html><b>V<sub>R</sub></b></html>" ) );
        help1.add( new JLabel( "speed when pilot lifts nose of aircraft to take off" ) );
        help1.add( new JLabel( "<html><b>V<sub>2</sub></b></html>" ) );
        help1.add( new JLabel( "minimum speed to climb safely even with engine failure" ) );
        help1.add( new JLabel( "inHg" ) );
        help1.add( new JLabel( "inch of mercury (1 inHg = 33.9 hPa)" ) );
        help1.add( new JLabel( "minimum runway length" ) );
        help1.add( new JLabel( "6'900 ft (1 ft = 0.3 m)" ) );
        help1.add( new JLabel( "empty weight" ) );
        help1.add( new JLabel( "41'413 kg" ) );
        
        helpf.add( help1, BorderLayout.CENTER );
        
        helpf.setTitle( "help" );
		helpf.setIconImage( fico.getImage() );
		helpf.pack();
		helpf.setResizable( false );
		helpf.setLocationRelativeTo( null );
		helpf.setVisible( true );
        
    }
    
	// info msg
	
	private static void infomsg() {
		
		String msg = "<html>" +
			"<b>Boeing 737-800 takeoff performence calculator</b><br />" +
			"Author: komed3 (Paul K\u00F6hler)<br />" +
			"Version: 1.02<br />" +
			"Date: 2021-06-30<br />" +
			"License: MIT<br />" +
			"<p style=\"color: red;\">" +
				"Do not use for real life flight!<br />" +
				"Valid for flight simulation use only!" +
			"</p>" +
		"</html>";
		
		JOptionPane.showMessageDialog(
			null, msg, "INFO",
			JOptionPane.INFORMATION_MESSAGE
		);
		
		reset();
		
	}
	
	// error msg
	
	private static void error( String msg ) {
		
		JOptionPane.showMessageDialog(
			null, msg, "ERROR",
			JOptionPane.ERROR_MESSAGE
		);
		
		reset();
		
	}
	
	// URL opener
	
	private static void openURL( String url ) {
		
		try {
			
			Desktop.getDesktop().browse( new URI( url ) );
			
		} catch( Exception e ) {}
		
	}
	
	// takeoff perf
	
	private static void toperf() {
		
		JFrame topf = new JFrame();
		
		ImageIcon cimg = new ImageIcon(
			top.class.getResource( "resources/perf_takeoff.gif" )
		);
		
		topf.add( new JLabel( cimg ) );
		
		topf.setTitle( "takeoff performence charts" );
		topf.setSize( cimg.getIconWidth(), cimg.getIconHeight() );
		topf.setIconImage( fico.getImage() );
		topf.setResizable( false );
		topf.setLocationRelativeTo( null );
		topf.setVisible( true );
		
	}
	
	// reset
	
	private static void reset() {
		
		spinner[0].setValue( 20 );
		spinner[1].setValue( 29.92 );
		spinner[2].setValue( 0 );
		spinner[3].setValue( 9200 );
		spinner[4].setValue( 50000 );
		
		combos[0].setSelectedItem( flpsPos[0] );
		checks[0].setSelected( false );
		
		speeds[0].setText( "" );
		speeds[1].setText( "" );
		speeds[2].setText( "" );
		
	}
	
	// calculate
	
	private static void calculate() {
		
		// read out arguments
		
		double temp = ( (Number) spinner[0].getValue() ).doubleValue();
		double pres = ( (Number) spinner[1].getValue() ).doubleValue();
		int elev = ( (Number) spinner[2].getValue() ).intValue();
		int arwy = ( (Number) spinner[3].getValue() ).intValue();
		int wght = ( (Number) spinner[4].getValue() ).intValue();
		int flps = combos[0].getSelectedIndex();
		
		// check weight
		
		if( wght < 41413 ) {
			
			error( "Boeing 737-800 empty weight is 41'413 kg!" );
			
		} else if( wght > 65000 ) {
			
			error( "Airplane to heavy to flight!" );
			
		} else if( arwy < 6900 ) {
			
			error( "Runway length must be at least 6'900 ft!" );
			
		} else {
			
			// calculate preference
			
			int psal = (int) Math.min( 9, Math.max( 0,
				Math.ceil( ( elev + 1000 * ( 29.92 - pres ) ) / 1000 )
			) );
			
			int tmpc = (int) Math.min( 7, Math.max( 1,
				Math.floor( temp / 10 )
			) ) - 1;
			
			int Xpref = pref[ psal ][ tmpc ];
			
			if( Xpref == -1 ) {
				
				error( "Flight not possible under these conditions!" );
			
			} else {
				
				// calculate v speeds
				
				int wt1t = (int) Math.ceil( wght / 5000 );
				
				int[] Xvspd = new int[3];
				Xvspd[0] = v1[ Xpref ][ flps ][ wt1t ];
				Xvspd[1] = vr[ Xpref ][ flps ][ wt1t ];
				Xvspd[2] = v2[ Xpref ][ flps ][ wt1t ];
				
				if( Xvspd[0] == -1 || Xvspd[1] == -1 || Xvspd[2] == -1 ) {
					
					error( "Flight not possible under these conditions!" );
					
				} else {
					
					// check wet runway
					
					if( checks[0].isSelected() ) {
						
						int ar1t = (int) Math.min( 7, Math.max( 0,
							Math.floor( arwy / 2000 )
						) );
						
						Xvspd[0] -= v1reduc[ flps ][ ar1t ];
						
					}
					
					// output v speeds
					
					speeds[0].setText( Xvspd[0] + " kts" );
					speeds[1].setText( Xvspd[1] + " kts" );
					speeds[2].setText( Xvspd[2] + " kts" );
					
				}
					
			}
			
		}
		
	}
	
	// run program
	
	public static void main( String[] args ) {
		
		top frame = new top();
		
		fico = new ImageIcon(
			top.class.getResource( "resources/icon.png" )
		);
		
		// build menu bar
		
		JMenuItem calc = new JMenuItem( "Calculate" );
		JMenuItem reset = new JMenuItem( "Reset" );
		JMenuItem helpme = new JMenuItem( "Help" );
		JMenuItem info = new JMenuItem( "Info" );
		JMenuItem chart = new JMenuItem( "Perf. charts" );
		JMenuItem code = new JMenuItem( "Source code" );
		JMenuItem donate = new JMenuItem( "Donate" );
		JMenuItem close = new JMenuItem( "Close" );
		
		JMenu menu = new JMenu( "Menu" );
		menu.add( calc );
		menu.add( reset );
		menu.addSeparator();
		menu.add( close );
		
		JMenu help = new JMenu( "Help" );
		help.add( helpme );
		help.add( info );
		help.add( chart );
		help.addSeparator();
		help.add( code );
		help.add( donate );
		
		JMenuBar mbar = new JMenuBar();
		mbar.add( menu );
		mbar.add( help );
		
		frame.setJMenuBar( mbar );
		
		// input fields
		
		spinner[0] = new JSpinner( new SpinnerNumberModel( 20, -90, 90, 0.2 ) );
		spinner[1] = new JSpinner( new SpinnerNumberModel( 29.92, 10, 50, 0.02 ) );
		spinner[2] = new JSpinner( new SpinnerNumberModel( 0, -1000, 20000, 5 ) );
		spinner[3] = new JSpinner( new SpinnerNumberModel( 9200, 0, 35000, 50 ) );
		spinner[4] = new JSpinner( new SpinnerNumberModel( 50000, 0, 100000, 10 ) );
		combos[0] = new JComboBox( flpsPos );
		checks[0] = new JCheckBox( "yes" );
		
		// build input panel
		
		JPanel inputs = new JPanel();
		inputs.setLayout( new GridLayout( 0, 2, 10, 10 ) );
		inputs.setBorder( new EmptyBorder( 20, 20, 10, 20 ) );
		
		inputs.add( new JLabel( "temperature (\u00B0C)" ) );
		inputs.add( spinner[0] );
		inputs.add( new JLabel( "pressure (inHg)" ) );
		inputs.add( spinner[1] );
		inputs.add( new JLabel( "elevation (ft)" ) );
		inputs.add( spinner[2] );
		inputs.add( new JLabel( "available runway (ft)" ) );
		inputs.add( spinner[3] );
		inputs.add( new JLabel( "weight (kg)" ) );
		inputs.add( spinner[4] );
		inputs.add( new JLabel( "Flaps position" ) );
		inputs.add( combos[0] );
		inputs.add( new JLabel( "Wet runway?" ) );
		inputs.add( checks[0] );
		
		// build output fields
		
		for( int i = 0; i < 3; i++ ) {
			
			speeds[ i ] = new JTextField();
			speeds[ i ].setEditable( false );
			speeds[ i ].setHorizontalAlignment( SwingConstants.RIGHT );
			speeds[ i ].setFont( speeds[ i ].getFont().deriveFont( Font.BOLD, 14f ) );
			
		}
		
		speeds[0].setBackground( new Color( 255, 180, 180 ) );
		speeds[1].setBackground( new Color( 140, 220, 140 ) );
		speeds[2].setBackground( new Color( 255, 255, 140 ) );
		
		JButton calcBtn = new JButton( "calculate" );
		JButton resetBtn = new JButton( "reset" );
		
		// build output panel
		
		JPanel output = new JPanel();
		output.setLayout( new GridLayout( 0, 2, 10, 10 ) );
		output.setBorder( new EmptyBorder( 20, 10, 20, 20 ) );
		
		output.add( new JLabel( "<html><b>V<sub>1</sub></b></html>" ) );
		output.add( speeds[0] );
		output.add( new JLabel( "<html><b>V<sub>R</sub></b></html>" ) );
		output.add( speeds[1] );
		output.add( new JLabel( "<html><b>V<sub>2</sub></b></html>" ) );
		output.add( speeds[2] );
		
		output.add( calcBtn );
		output.add( resetBtn );
		
		for( int i = 0; i < 6; i++ ) {
			output.add( new JLabel( " " ) );
		}
		
		// disclaimer
		
		JLabel disclaimer = new JLabel(
			"Do not use for real life flight! " +
			"Valid for flight simulation use only!",
			SwingConstants.CENTER
		);
		
		disclaimer.setForeground( Color.RED );
		disclaimer.setFont( disclaimer.getFont().deriveFont( Font.BOLD, 14f ) );
		disclaimer.setBorder( new EmptyBorder( 5, 0, 20, 0 ) );
		
		// build grid layout
		
		frame.setLayout( new BorderLayout() );
		
		frame.add( inputs, BorderLayout.LINE_START );
		
		frame.add( output, BorderLayout.LINE_END );
		
		frame.add( disclaimer, BorderLayout.PAGE_END );
		
		// action listener
		
		calc.addActionListener( e -> {
			calculate();
		} );
		
		calcBtn.addActionListener( e -> {
			calculate();
		} );
		
		reset.addActionListener( e -> {
			reset();
		} );
		
		resetBtn.addActionListener( e -> {
			reset();
		} );
		
		info.addActionListener( e -> {
			infomsg();
		} );
		
		helpme.addActionListener( e -> {
			helpdesk();
		} );
		
		chart.addActionListener( e -> {
			toperf();
		} );
		
		code.addActionListener( e -> {
			openURL( "https://github.com/komed3/tos-737-800/" );
		} );
		
		donate.addActionListener( e -> {
			openURL( "https://paypal.me/komed3/" );
		} );
		
		close.addActionListener( e -> {
			frame.dispose();
		} );
		
		// build frame
		
		reset();
		
		frame.setTitle( "Boeing 737-800 takeoff performence calculator" );
		frame.setDefaultCloseOperation( frame.EXIT_ON_CLOSE );
		frame.setIconImage( fico.getImage() );
		frame.setSize( 600, 400 );
		frame.setResizable( false );
		frame.setLocationRelativeTo( null );
		frame.setVisible( true );
		
	}
	
}
