// Frame for the Sketcher application
package Sketcher6;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import java.awt.Color;

import static java.awt.event.InputEvent.*;
import static java.awt.Color.*;
import static Sketcher6.Constants.SketcherConstants.CIRCLE;
import static Sketcher6.Constants.SketcherConstants.CURVE;
import static Sketcher6.Constants.SketcherConstants.DEFAULT_ELEMENT_COLOR;
import static Sketcher6.Constants.SketcherConstants.LINE;
import static Sketcher6.Constants.SketcherConstants.RECTANGLE;

public class SketchFrame extends JFrame {

    private int DEFAULT_ELEMENT_TYPE;
  // Constructor
  public SketchFrame(String title) {
    setTitle(title);                             // Set the window title
    setJMenuBar(menuBar);                        // Add the menu bar to the window
    setDefaultCloseOperation(EXIT_ON_CLOSE);     // Default is exit the application

    JMenu fileMenu = new JMenu("File");          // Create File menu
    JMenu elementMenu = new JMenu("Elements");   // Create Elements menu
    fileMenu.setMnemonic('F');                   // Create shortcut
    elementMenu.setMnemonic('E');                // Create shortcut

    // Create the action items for the file menu
    newAction = new FileAction("New", KeyStroke.getKeyStroke('N', CTRL_DOWN_MASK));
    openAction = new FileAction("Open", KeyStroke.getKeyStroke('O', CTRL_DOWN_MASK));
    closeAction = new FileAction("Close");
    saveAction = new FileAction("Save", KeyStroke.getKeyStroke('S', CTRL_DOWN_MASK));
    saveAsAction = new FileAction("Save As...");
    printAction = new FileAction("Print", KeyStroke.getKeyStroke('P', CTRL_DOWN_MASK));

    // Construct the file drop-down menu
    fileMenu.add(new JMenuItem(newAction));
    fileMenu.add(new JMenuItem(openAction));
    fileMenu.add(new JMenuItem(closeAction));
    fileMenu.addSeparator();                     // Add separator
    fileMenu.add(new JMenuItem(saveAction));
    fileMenu.add(new JMenuItem(saveAsAction));
    fileMenu.addSeparator();                     // Add separator
    fileMenu.add(new JMenuItem(printAction));

    // Construct the Element drop-down menu
    elementMenu.add(new JMenuItem(lineAction = new TypeAction("Line", LINE)));
    elementMenu.add(new JMenuItem(rectangleAction = new TypeAction("Rectangle", RECTANGLE)));
    elementMenu.add(new JMenuItem(circleAction = new TypeAction("Circle", CIRCLE)));
    elementMenu.add(new JMenuItem(curveAction = new TypeAction("Curve", CURVE)));
    elementMenu.addSeparator();

    JMenu colorMenu = new JMenu("Color");        // Color sub-menu
    elementMenu.add(colorMenu);                  // Add the sub-menu

    colorMenu.add(new JMenuItem(redAction = new ColorAction("Red", RED)));
    colorMenu.add(new JMenuItem(yellowAction = new ColorAction("Yellow", YELLOW)));
    colorMenu.add(new JMenuItem(greenAction = new ColorAction("Green", GREEN)));
    colorMenu.add(new JMenuItem(blueAction = new ColorAction("Blue", BLUE)));

    menuBar.add(fileMenu);                       // Add the file menu
    menuBar.add(elementMenu);                    // Add the element menu
  }

  // Inner class defining Action objects for File menu items
  class FileAction extends AbstractAction {    
    // Constructor
    FileAction(String name) {
      super(name);
    }

   // Constructor
    FileAction(String name, KeyStroke keystroke) {
      this(name);
      if(keystroke != null) {
        putValue(ACCELERATOR_KEY, keystroke);
      }
    }

    // Event handler
    public void actionPerformed(ActionEvent e) {
      // You will add action code here eventually...
    }
  }

  // Inner class defining Action objects for Element type menu items
  class TypeAction extends AbstractAction {    
    TypeAction(String name, int typeID) {
      super(name);
      this.typeID = typeID;
    }
  
    public void actionPerformed(ActionEvent e) {
      elementType = typeID;  
    }

    private int typeID;
  }

  // Handles color menu items
  class ColorAction  extends AbstractAction {
    public ColorAction(String name, Color color) {
      super(name);
      this.color = color;
    }

    public void actionPerformed(ActionEvent e) {
      elementColor = color;

      // This is temporary - just to show it works...
      getContentPane().setBackground(color);
    }

    private Color color;
  }

  // File actions
  private FileAction newAction, openAction, closeAction,
                     saveAction, saveAsAction, printAction;

  // Element type actions
  private TypeAction lineAction, rectangleAction, circleAction, curveAction;

  // Element color actions
  private ColorAction redAction, yellowAction,
                      greenAction, blueAction;

  private JMenuBar menuBar = new JMenuBar();           // Window menu bar
  private Color elementColor = DEFAULT_ELEMENT_COLOR;  // Current element color
  private int elementType = DEFAULT_ELEMENT_TYPE;      // Current element type

}
