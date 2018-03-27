package view;

import javax.swing.*;

import observerForms.BusBoyStateNotify;
import observerForms.TableStateNotify;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class RestaurantView extends Observable implements Observer {
	
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	
	JFrame frame;
	JButton[] buttons;
	JTextArea textArea;
	
	GridBagConstraints c;
	
	public class goodAction implements ActionListener {

		RestaurantView r;
		int whichPass;
		
		goodAction(RestaurantView _r, int _whichPass) {
			r = _r;
			whichPass = _whichPass;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//Send to controller method where it gets handled
			//send 0 down in a view notify
			if(whichPass == 1)
				r.notifyObservers(new TableStateNotify(0, null));
			if(whichPass == 2)
				r.notifyObservers(new BusBoyStateNotify("BackroomState"));
		}
		
	}
	
	public RestaurantView() {
		frame = new JFrame("Restaurant View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new java.awt.Dimension(1600, 900));
		Container pane = frame.getContentPane();
		pane.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
	    
		buttons = new JButton[7];
		
		c.ipady = 50;
	    c.ipadx = 50;
	    c.gridx = 0;
	    c.gridy = 0;
	    c.weightx = 1;
	    c.weighty = 3;
	    buttons[0] = new JButton("Table 0");
	    pane.add(buttons[0], c);
		
		c.ipady = 50;
	    c.ipadx = 50;
		c.gridx = 5;
		c.gridy = 0;
		c.weightx = 1;
	    c.weighty = 3;
	    buttons[1] = new JButton("Table 1");
		pane.add(buttons[1], c);
		
		buttons[2] = new JButton("Table 2");
		c.gridx = 0;
		c.gridy = 1;
		pane.add(buttons[2], c);
		
		buttons[3] = new JButton("Table 3");
		c.gridx = 5;
		c.gridy = 1;
		pane.add(buttons[3], c);
		
		buttons[4] = new JButton("                  Banquet 4                  ");
		c.gridx = 0;
		c.gridy = 2;
		pane.add(buttons[4], c);
		
		buttons[5] = new JButton("                  Banquet 5                  ");
		c.gridx = 5;
		c.gridy = 2;
		pane.add(buttons[5], c);
		
		buttons[6] = new JButton("Busboy 6");
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.PAGE_END;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 6;
		pane.add(buttons[6], c);
		
		JScrollPane jScrollPane;
		
		textArea = new JTextArea("History Log:");
		textArea.setColumns(30);
		c.gridx = 6;
		c.gridy = 0;
		c.gridheight = 5;
		c.gridwidth = GridBagConstraints.RELATIVE;
		jScrollPane = new JScrollPane(textArea);
		pane.add(textArea,c);
		
		for(int i = 0; i < buttons.length - 1; i++) {
			buttons[i].addActionListener(new goodAction(this,1));
			buttons[i].setBackground(Color.CYAN);
		}
		
		//For busboy
		buttons[6].addActionListener(new goodAction(this,2));
		buttons[6].setBackground(Color.GRAY);
		
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg1) {
		//If table form
		if(arg1.toString().equals("TableStateNotify")) {
			//change color accordingly
			TableStateNotify tableStateNotify = (TableStateNotify)arg1;
			switch (tableStateNotify.getTableState()) {
			case "ReadyTable":
				buttons[tableStateNotify.tablePosition].setBackground(Color.GREEN);
				break;
			case "InUseTable":
				buttons[tableStateNotify.tablePosition].setBackground(Color.RED);
				break;
			case "NeedsCleaningTable":
				buttons[tableStateNotify.tablePosition].setBackground(Color.YELLOW);
				break;
			case "BeingCleanedTable":
				buttons[tableStateNotify.tablePosition].setBackground(Color.ORANGE);
				break;
			default:
				break;
			}
			//update log
			 textArea.append( "Table has updated to " + tableStateNotify.getTableState());
		}
			
		//If busboy form
		if(arg1.toString().equals("BusBoyStateNotify")) {
			//update accordingly
			//UPDATE BUSBOY DEPENDING ON STATE
			BusBoyStateNotify busBoyStateNotify = (BusBoyStateNotify)arg1;
			switch (busBoyStateNotify.busBoyState) {
			case "OffShift":
				buttons[6].setBackground(Color.RED);
				break;
			case "BackroomState":
				buttons[6].setBackground(Color.YELLOW);
				break;
			case "CleaningState":
				buttons[6].setBackground(Color.GREEN);
				break;
			default:
				break;
			}
			//update log
			//UPDATE LOG
			textArea.append("Busboy has updated to " + busBoyStateNotify.busBoyState);
		}
			
	}

}

