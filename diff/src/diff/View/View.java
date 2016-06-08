package diff.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import Util.ModelUtil;
import Util.StringUtil;
import diff.Controller;
import diff.Model.CompareModel;
import diff.Model.FileModel;

public class View extends JFrame implements ActionListener {

	private JToolBar toptoolbar = new JToolBar();
	private JSplitPane sp;
	private JButton compareBt = new JButton("Compare");
	private JButton copy2rightBt = new JButton("C2R");
	private JButton copy2leftBt = new JButton("C2L");
	private JFileChooser filechooser = new JFileChooser();
	private Controller controller;
	private FileModel fileModel = new FileModel();
	private TextAreaWithToolbarOnJPanel leftPanel;
	private TextAreaWithToolbarOnJPanel rightPanel;
	private CompareModel compareModel;

	public View() {
		this.setTitle("Diff");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 640);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		toptoolbar.setFloatable(false);
		toptoolbar.add(compareBt);
		toptoolbar.add(copy2rightBt);
		toptoolbar.add(copy2leftBt);

		this.add(sp, BorderLayout.CENTER);
		this.add(toptoolbar, BorderLayout.NORTH);

		compareBt.addActionListener(this);
		compareBt.setEnabled(false);
		copy2rightBt.addActionListener(this);
		copy2rightBt.setEnabled(false);
		copy2leftBt.addActionListener(this);
		copy2leftBt.setEnabled(false);

		leftPanel = new TextAreaWithToolbarOnJPanel("leftpanel");
		rightPanel = new TextAreaWithToolbarOnJPanel("rightpanel");
		sp.setResizeWeight(.5d);
		sp.setLeftComponent(leftPanel);
		sp.setRightComponent(rightPanel);
	}
	/**
	 * View 메인 프레임의 액션을 정의합니다. Compare, CopyToRight, CopyToLeft.
	 */
	public void actionPerformed(ActionEvent e) {

		JButton Button = (JButton) e.getSource();
		if (Button.equals(compareBt)) {
			if(compareModel!=null&&compareModel.getFileModel().equals(fileModel))fileModel=ModelUtil.getOriginal(compareModel);
			compareModel = controller.compare(fileModel);
			fileModel = compareModel.getFileModel();
			leftPanel.textarea.setCompare(compareModel.getLeft());
			leftPanel.textarea.setText(StringUtil.mergeString(compareModel.getFileModel().getLeft()));
			rightPanel.textarea.setCompare(compareModel.getRight());
			rightPanel.textarea.setText(StringUtil.mergeString(compareModel.getFileModel().getRight()));
			/*if(fileModel.getLeft().size()>=fileModel.getRight().size())
				leftPanel.sb.setModel(rightPanel.sb.getModel());
			else
				rightPanel.sb.setModel(leftPanel.sb.getModel());*/
			super.repaint();
		}
		if (Button.equals(copy2rightBt)){
			fileModel=controller.merge(false, fileModel, compareModel, leftPanel.textarea.getRowPos());
			leftPanel.textarea.setText(StringUtil.mergeString(fileModel.getLeft()));
			rightPanel.textarea.setText(StringUtil.mergeString(fileModel.getRight()));
			super.repaint();
		}
		if (Button.equals(copy2leftBt)){
			fileModel=controller.merge(true, fileModel, compareModel, rightPanel.textarea.getRowPos());
			leftPanel.textarea.setText(StringUtil.mergeString(fileModel.getLeft()));
			rightPanel.textarea.setText(StringUtil.mergeString(fileModel.getRight()));
			super.repaint();
		}		
	}

	public void setController(Controller ct) {
		controller = ct;
	}
	/**
	 * 좌우 각 패널을 하나의 클래스로 정의. TextArea, 툴바, 버튼, 스크롤바를 포함한 JPanel입니다.
	 */	
	public class TextAreaWithToolbarOnJPanel extends JPanel implements ActionListener {

		public TextAreaWithToolbarOnJPanel getLeftTextPanel() {
			return leftPanel;
		}

		public TextAreaWithToolbarOnJPanel getRightTextPanel() {
			return rightPanel;
		}

		private JToolBar toolbar;
		private JScrollPane scrollpane;
		private JScrollBar sb;
		private ColoredJTextPane textarea;
		private StyledDocument doc;
		private Style def, s;
		private JButton loadBt, editBt, saveBt;
		private boolean isEditable, isLeft;
		private boolean isLoaded = false;

		public TextAreaWithToolbarOnJPanel(String str) {
			loadBt = new JButton("Load");
			editBt = new JButton("Edit");
			isEditable = false;
			saveBt = new JButton("Save");

			if (str == "leftpanel")
				isLeft = true;
			else
				isLeft = false;

			toolbar = new JToolBar();
			textarea = new ColoredJTextPane();

			loadBt.addActionListener(this);
			editBt.addActionListener(this);
			saveBt.addActionListener(this);

			doc = textarea.getStyledDocument();
			def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
			s = doc.addStyle("black", def);
			StyleConstants.setForeground(s, Color.black);
			s = doc.addStyle("blue", def);
			StyleConstants.setForeground(s, Color.blue);
			s = doc.addStyle("red", def);
			StyleConstants.setForeground(s, Color.red);

			textarea.setEditable(false);
			scrollpane = new JScrollPane(textarea);
			scrollpane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			toolbar.add(loadBt);
			toolbar.add(editBt);
			toolbar.add(saveBt);
			toolbar.setFloatable(false);

			scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			sb=scrollpane.getVerticalScrollBar();
			this.setLayout(new BorderLayout());
			this.add(toolbar, BorderLayout.NORTH);
			this.add(scrollpane, BorderLayout.CENTER);

		}
		private void switchEdit(boolean b) {
			isEditable = b;
		}
		private void DisableBts(boolean b,boolean lr) {
			textarea.setEditable(b);
			loadBt.setEnabled(!b);
			saveBt.setEnabled(!b);
			compareBt.setEnabled(!b);
			copy2rightBt.setEnabled(!b);
			copy2leftBt.setEnabled(!b);
			if(lr){
			rightPanel.loadBt.setEnabled(!b);
			rightPanel.editBt.setEnabled(!b);
			rightPanel.saveBt.setEnabled(!b);
			}
			else{
				leftPanel.loadBt.setEnabled(!b);
				leftPanel.editBt.setEnabled(!b);
				leftPanel.saveBt.setEnabled(!b);
			}
		}
		/**
		 * TextAreaWithToolbarOnJPanel 즉 좌우 패널의 버튼 액션을 정의합니다. load, save, edit.
		 */		
		public void actionPerformed(ActionEvent e) {
			JButton Button = (JButton) e.getSource();
			File file = null;

			if (Button.equals(loadBt)) {
				int returnval = filechooser.showOpenDialog(null);

				if (returnval == JFileChooser.APPROVE_OPTION)
					file = filechooser.getSelectedFile();
				else if(returnval != JFileChooser.APPROVE_OPTION)
			    	return;
				fileModel = controller.load(isLeft, file, fileModel);
				textarea.setText(null);
				if (isLeft) {
					isLoaded = true;
					textarea.setText(StringUtil.mergeString(fileModel.getLeft()));
				} else {
					isLoaded = true;
					textarea.setText(StringUtil.mergeString(fileModel.getRight()));
				}
				if (leftPanel.isLoaded == true && rightPanel.isLoaded == true) {
					compareBt.setEnabled(true);
					copy2rightBt.setEnabled(true);
					copy2leftBt.setEnabled(true);
				}
				fileModel = controller.edit(true, fileModel, leftPanel.textarea);
				fileModel = controller.edit(false, fileModel, rightPanel.textarea);
			}
			if (Button.equals(leftPanel.editBt)) {
				if (isEditable == false) {
					DisableBts(true,true);
					switchEdit(true);
				} else {
					DisableBts(false,true);
					fileModel = controller.edit(true, fileModel, textarea);
					switchEdit(false);
				}
			}
			if (Button.equals(rightPanel.editBt)) {
				if (isEditable == false) {
					DisableBts(true,false);
					switchEdit(true);
				} else {
					DisableBts(false,false);
					fileModel = controller.edit(false, fileModel, textarea);
					switchEdit(false);
				}
			}
			if (Button.equals(leftPanel.saveBt)) {
				int returnval = filechooser.showSaveDialog(null);

				if (returnval == JFileChooser.APPROVE_OPTION)
					file = filechooser.getSelectedFile();
				else if(returnval != JFileChooser.APPROVE_OPTION)
			    	return;
				controller.save(true, file, fileModel);
			}
			if (Button.equals(rightPanel.saveBt)) {
				controller.save(false, file, fileModel);
			}
		}
	}
}