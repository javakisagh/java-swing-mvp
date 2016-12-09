package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presenter.Presenter;

public class MainWindow extends JFrame {
	
	private JButton next;
	private Board board;
	
	public void init(Presenter p) {
		this.setTitle("Okno");
		this.setSize(400, 300);
		createControlls();
		bindTo(p);
		
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(1, 2);
		panel.setLayout(layout);
		panel.add(next);
		panel.add(board);
		this.add(panel,BorderLayout.CENTER);
		this.setVisible(true);
	}

	private void createControlls() {
		System.out.println(Thread.currentThread().getStackTrace()[1]);
		next = new JButton("NEXT");
		board = new Board(15,15);
	}
	
	public void bindTo(final Presenter p) {
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p.nextClicked();
			}
		});
		board.addMouseListener(board.createMouseListner(p));
	}
	
	public void resizeBoardSizeInCellsTo(int xCells,int yCells) {
		board.resizeBoardSizeInCellsTo(xCells, yCells);
	}

	public void changeCell(int x, int y, int state) {
		board.setCellTo(x, y, state);
		board.repaint();
	}

}
