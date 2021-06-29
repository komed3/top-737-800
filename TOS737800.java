import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Scanner;
import java.net.URI;

public class TOS737800 extends JFrame {
	
	static Scanner s = new Scanner( System.in );
	
	// take off preference tables
	
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
	
	public static void main( String[] args ) {
		
		TOS737800 frame = new TOS737800();
		
		// build menu bar
		
		JMenuItem calc = new JMenuItem( "Calculate" );
		JMenuItem reset = new JMenuItem( "Reset" );
		JMenuItem help = new JMenuItem( "Help" );
		JMenuItem code = new JMenuItem( "Source Code" );
		JMenuItem donate = new JMenuItem( "Donate" );
		JMenuItem close = new JMenuItem( "Close" );
		
		JMenu menu = new JMenu( "Menu" );
		menu.add( calc );
		menu.add( reset );
		menu.addSeparator();
		menu.add( help );
		menu.add( code );
		menu.add( donate );
		menu.addSeparator();
		menu.add( close );
		
		JMenuBar mbar = new JMenuBar();
		mbar.add( menu );
		
		frame.setJMenuBar( mbar );
		
		// input fields
		
		JSpinner Ftemp = new JSpinner( new SpinnerNumberModel( 20, -90, 90, 0.2 ) );
		JSpinner Fpres = new JSpinner( new SpinnerNumberModel( 29.92, 20, 40, 0.02 ) );
		JSpinner Felev = new JSpinner( new SpinnerNumberModel( 0, -1000, 20000, 5 ) );
		JSpinner Farwy = new JSpinner( new SpinnerNumberModel( 6500, 2000, 20000, 10 ) );
		JSpinner Fwght = new JSpinner( new SpinnerNumberModel( 35000, 20000, 70000, 10 ) );
		JComboBox Fflps = new JComboBox( new String[] { "1", "5", "15" } );
		JCheckBox Fwrwy = new JCheckBox( "yes" );
		
		// build input panel
		
		JPanel inputs = new JPanel();
		inputs.setLayout( new GridLayout( 0, 2, 15, 15 ) );
		inputs.setBorder( new EmptyBorder( 15, 20, 15, 20 ) );
		
		inputs.add( new JLabel( "temperature (°C)" ) );
		inputs.add( Ftemp );
		inputs.add( new JLabel( "pressure (inHg)" ) );
		inputs.add( Fpres );
		inputs.add( new JLabel( "elevation (ft)" ) );
		inputs.add( Felev );
		inputs.add( new JLabel( "available runway (ft)" ) );
		inputs.add( Farwy );
		inputs.add( new JLabel( "weight (kg)" ) );
		inputs.add( Fwght );
		inputs.add( new JLabel( "Flaps position" ) );
		inputs.add( Fflps );
		inputs.add( new JLabel( "Wet runway?" ) );
		inputs.add( Fwrwy );
		
		// build output fields
		
		JTextField outV1 = new JTextField();
		outV1.setBackground( new Color( 255, 180, 180 ) );
		JTextField outVr = new JTextField();
		outVr.setBackground( new Color( 140, 220, 140 ) );
		JTextField outV2 = new JTextField();
		outV2.setBackground( new Color( 255, 255, 140 ) );
		
		JButton calcNow = new JButton( "calculate" );
		JButton restNow = new JButton( "reset" );
		
		// build output panel
		
		JPanel output = new JPanel();
		output.setLayout( new GridLayout( 0, 2, 15, 15 ) );
		output.setBorder( new EmptyBorder( 15, 20, 15, 20 ) );
		
		output.add( new JLabel( "<html>v<sub>1</sub></html>" ) );
		output.add( outV1 );
		output.add( new JLabel( "<html>v<sub>r</sub></html>" ) );
		output.add( outVr );
		output.add( new JLabel( "<html>v<sub>2</sub></html>" ) );
		output.add( outV2 );
		
		output.add( calcNow );
		output.add( restNow );
		
		for( int i = 0; i < 6; i++ ) {
			output.add( new JLabel( " " ) );
		}
		
		// build grid layout
		
		frame.setLayout( new BorderLayout() );
		
		frame.add( inputs, BorderLayout.LINE_START );
		
		frame.add( output, BorderLayout.LINE_END );
		
		frame.add(
			new JLabel( "<html>" +
				"<p style='padding: 6px; color: red; font-size: 1.1em;'>" +
					"Do not use for real life flight! Valid for flight simulation use only!" +
				"</p>" +
			"</html>", SwingConstants.CENTER ),
			BorderLayout.PAGE_END
		);
		
		// action listener
		
		help.addActionListener( e-> {
			
			try {
				
				Desktop.getDesktop().browse( new URI( "https://github.com/komed3/tos-737-800/blob/main/README.md" ) );
				
			} catch( Exception except ) {}
			
		} );
		
		code.addActionListener( e-> {
			
			try {
				
				Desktop.getDesktop().browse( new URI( "https://github.com/komed3/tos-737-800/" ) );
				
			} catch( Exception except ) {}
			
		} );
		
		donate.addActionListener( e-> {
			
			try {
				
				Desktop.getDesktop().browse( new URI( "https://paypal.me/komed3/" ) );
				
			} catch( Exception except ) {}
			
		} );
		
		close.addActionListener( e -> {
			
			frame.dispose();
			
		} );
		
		// build frame
		
		frame.setTitle( "Boeing 737-800 takeoff speed calculator" );
		frame.setDefaultCloseOperation( frame.EXIT_ON_CLOSE );
		frame.setSize( 600, 400 );
		frame.setResizable( false );
		frame.setLocation( 50, 50 );
		frame.setVisible( true );
		
	}
	
}
