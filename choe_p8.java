
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;

public class choe_p8 {

    private static int[] sortValues;
    private static int[] searchValues;

    private static int[] sortedValues;
    private static TreeSet<Integer> treeSetValues = new TreeSet<>();
    private static HashSet<Integer> hashSetValues = new HashSet<>();
    private static PriorityQueue<Integer> priorityQueueValues = new PriorityQueue<>();
    private static ArrayList<Integer> arrayListValues = new ArrayList<>();
    private static ArrayList<Integer> sortedArrayListValues = new ArrayList<>();
    private static choe_BinarySearchTree bst;
    private static int[] unsortedValues;

    private static String readSort = "";
    private static String readSearch = "";

    private static boolean readSearchIsClicked = false;
    private static boolean sortIntIsClicked = false;
    private static boolean addToBstIsClicked = false;
    private static boolean addToTreeSetIsClicked = false;
    private static boolean addToPriorityQueueIsClicked = false;
    private static boolean addToHashSetIsClicked = false;
    private static boolean addToArrayListIsClicked = false;
    private static boolean addToSortedAraryListIsClicked = false;
    private static boolean addToArrayIsClicked = false;

    // create left buttons and labels
    static JButton sortIntsButton = new JButton("sorts ints");
    static JLabel sortIntsLabel = new JLabel("no result");

    static JButton addToBstButton = new JButton("add to bst");
    static JLabel addToBstLabel = new JLabel("no result");

    static JButton addToTreeSetButton = new JButton("add to treeset");
    static JLabel addToTreeSetLabel = new JLabel("no result");

    static JButton addToPriorityQueueButton = new JButton("add to priority queue");
    static JLabel addToPriorityQueueLabel = new JLabel("no result");

    static JButton addToHashSetButton = new JButton("add to hashset");
    static JLabel addToHashSetLabel = new JLabel("no result");

    static JButton addToArrayListButton = new JButton("add to arraylist");
    static JLabel addToArrayListLabel = new JLabel("no result");

    static JButton addToSortedArrayListButton = new JButton("add to sorted arraylist");
    static JLabel addToSortedArrayListLabel = new JLabel("no result");

    static JButton addToArrayButton = new JButton("add to array");
    static JLabel addToArrayLabel = new JLabel("no result");

    // create right buttons and labels
    static JButton searchIntsButton = new JButton("search sorted ints");
    static JLabel searchIntsLabel = new JLabel("no result");

    static JButton searchBstButton = new JButton("search bst");
    static JLabel searchBstLabel = new JLabel("no result");

    static JButton searchTreesetButton = new JButton("search treeset");
    static JLabel searchTreesetLabel = new JLabel("no result");

    static JButton searchPriorityQueueButton = new JButton("search priority queue");
    static JLabel searchPriorityQueueLabel = new JLabel("no result");

    static JButton searchHashSetButton = new JButton("search hashset");
    static JLabel searchHashSetLabel = new JLabel("no result");

    static JButton searchArrayListButton = new JButton("search arraylist");
    static JLabel searchArrayListLabel = new JLabel("no result");

    static JButton searchSortedArrayListButton = new JButton("search sorted arraylist");
    static JLabel searchSortedArrayListLabel = new JLabel("no result");

    static JButton searchArrayButton = new JButton("search array");
    static JLabel searchArrayLabel = new JLabel("no result");

    private static String sortFile = "";
    private static String searchFile = "";

    public static void main(String[] args) {
        if (args.length == 2) {
            sortFile = args[0];
            searchFile = args[1];
        } else {
            System.out.println("format: choe_prog8 sortFileName searchFileName");
        }

        createFrame();

    }

    static class MenuItemActionListener implements ActionListener {
        // menu item is associated this action listener

        private JMenuItem m; // menu variable

        MenuItemActionListener(JMenuItem m) {
            this.m = m;
        }

        public void actionPerformed(ActionEvent e) {
            if (m.getText().toLowerCase().equals("exit")) {
                System.exit(0);
            }
            if (m.getText().toLowerCase().equals("read sort file")) {
                buttonMethods.readData(sortFile, true);
                System.out.println("read sort file");
            }
            if (m.getText().toLowerCase().equals("read search file")) {

                buttonMethods.readData(searchFile, false);
                System.out.println("read search file");
            }
        }
    }

    static class ButtonActionListener implements ActionListener {

        private JButton b; // button variable

        ButtonActionListener(JButton b) {
            this.b = b;
        }

        public void actionPerformed(ActionEvent e) {

            System.out.println(b.getText());

            switch (b.getText().toLowerCase()) {
                case "sorts ints":
                    long t0 = System.currentTimeMillis();
                    buttonMethods.selectionSort();

                    long t1 = System.currentTimeMillis();

                    long timeToRun = t1 - t0;

                    sortIntsLabel.setText(timeToRun + "ms");

                    sortIntIsClicked = true;
                    if (readSearchIsClicked) {
                        searchIntsButton.setEnabled(true);
                    }
                    break;
                case "add to bst":
                    t0 = System.currentTimeMillis();

                    buttonMethods.addToBinarySearchTree();

                    t1 = System.currentTimeMillis();

                    timeToRun = t1 - t0;

                    addToBstLabel.setText(timeToRun + "ms");

                    addToBstIsClicked = true;
                    if (readSearchIsClicked) {
                        searchBstButton.setEnabled(true);
                    }
                    break;
                case "add to treeset":
                    t0 = System.currentTimeMillis();
                    buttonMethods.addToTreeSet();
                    t1 = System.currentTimeMillis();

                    timeToRun = t1 - t0;
                    addToTreeSetLabel.setText(timeToRun + "ms");

                    addToTreeSetIsClicked = true;
                    if (readSearchIsClicked) {
                        searchTreesetButton.setEnabled(true);
                    }
                    break;

                case "add to priority queue":
                    t0 = System.currentTimeMillis();
                    buttonMethods.addToPriorityQueue();
                    t1 = System.currentTimeMillis();

                    timeToRun = t1 - t0;
                    addToPriorityQueueLabel.setText(timeToRun + "ms");

                    addToPriorityQueueIsClicked = true;
                    if (readSearchIsClicked) {
                        searchPriorityQueueButton.setEnabled(true);
                    }
                    break;

                case "add to hashset":
                    t0 = System.currentTimeMillis();
                    buttonMethods.addToHashSet();
                    t1 = System.currentTimeMillis();
                    timeToRun = t1 - t0;
                    addToHashSetLabel.setText(timeToRun + "ms");

                    addToHashSetIsClicked = true;
                    if (readSearchIsClicked) {
                        searchHashSetButton.setEnabled(true);
                    }
                    break;

                case "add to arraylist":
                    t0 = System.currentTimeMillis();
                    buttonMethods.addToArrayList();
                    t1 = System.currentTimeMillis();
                    timeToRun = t1 - t0;
                    addToArrayListLabel.setText(timeToRun + "ms");

                    addToArrayListIsClicked = true;
                    if (readSearchIsClicked) {
                        searchArrayListButton.setEnabled(true);
                    }
                    break;

                case "add to sorted arraylist":
                    t0 = System.currentTimeMillis();
                    buttonMethods.addToSortedArrayList();
                    t1 = System.currentTimeMillis();
                    timeToRun = t1 - t0;
                    addToSortedArrayListLabel.setText(timeToRun + "ms");

                    addToSortedAraryListIsClicked = true;
                    if (readSearchIsClicked) {
                        searchSortedArrayListButton.setEnabled(true);
                    }
                    break;

                case "add to array":
                    t0 = System.currentTimeMillis();
                    buttonMethods.addToArray();
                    t1 = System.currentTimeMillis();
                    timeToRun = t1 - t0;
                    addToArrayLabel.setText(timeToRun + "ms");

                    addToArrayIsClicked = true;
                    if (readSearchIsClicked) {
                        searchArrayButton.setEnabled(true);
                    }
                    break;

                case "search sorted ints":
                    t0 = System.currentTimeMillis();
                    int values = buttonMethods.searchInts();
                    t1 = System.currentTimeMillis();
                    timeToRun = t1 - t0;
                    searchIntsLabel.setText(values + " / " + (timeToRun + "ms"));

                    break;

                case "search bst":
                    t0 = System.currentTimeMillis();
                    values = buttonMethods.searchBinarySearchTree();
                    t1 = System.currentTimeMillis();
                    timeToRun = t1 - t0;
                    searchBstLabel.setText(values + " / " + (timeToRun + "ms"));

                    break;

                case "search treeset":
                    t0 = System.currentTimeMillis();
                    values = buttonMethods.searchTreeSet();
                    t1 = System.currentTimeMillis();
                    timeToRun = t1 - t0;
                    searchTreesetLabel.setText(values + " / " + (timeToRun + "ms"));
                    break;

                case "search priority queue":
                    t0 = System.currentTimeMillis();
                    values = buttonMethods.searchPriorityQueue();
                    t1 = System.currentTimeMillis();
                    timeToRun = t1 - t0;
                    searchPriorityQueueLabel.setText(values + " / " + (timeToRun + "ms"));
                    break;

                case "search hashset":
                    t0 = System.currentTimeMillis();
                    values = buttonMethods.searchHashSet();
                    t1 = System.currentTimeMillis();
                    timeToRun = t1 - t0;
                    searchHashSetLabel.setText(values + " / " + (timeToRun + "ms"));
                    break;

                case "search arraylist":
                    t0 = System.currentTimeMillis();
                    values = buttonMethods.searchArrayList();
                    t1 = System.currentTimeMillis();
                    timeToRun = t1 - t0;
                    searchArrayListLabel.setText(values + " / " + (timeToRun + "ms"));
                    break;

                case "search sorted arraylist":
                    t0 = System.currentTimeMillis();
                    values = buttonMethods.searchSortedArrayList();
                    t1 = System.currentTimeMillis();
                    timeToRun = t1 - t0;
                    searchSortedArrayListLabel.setText(values + " / " + (timeToRun + "ms"));
                    break;

                case "search array":
                    t0 = System.currentTimeMillis();
                    values = buttonMethods.searchArray();
                    t1 = System.currentTimeMillis();
                    timeToRun = t1 - t0;
                    searchArrayLabel.setText(values + " / " + (timeToRun + "ms"));
                    break;
                default:
                    break;
            }
        }
    }

    public static void createFrame() {

        final int width = 700;
        final int height = 350;

        JFrame f = new JFrame(); // create frame

        // set JFrame settings
        f.setPreferredSize(new Dimension(width, height));
        f.setMinimumSize(new Dimension(width, height));
        f.setMaximumSize(new Dimension(width, height));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar(); // create menu bar

        // create menus:
        JMenu fileMenu = new JMenu("File");

        // menu items:
        JMenuItem readSort = new JMenuItem("Read sort file");
        JMenuItem readSearch = new JMenuItem("Read search file");
        JMenuItem exit = new JMenuItem("Exit");

        // create then add actionListeners to items
        MenuItemActionListener fileMenuAL = new MenuItemActionListener(fileMenu);
        MenuItemActionListener readSortAL = new MenuItemActionListener(readSort);
        MenuItemActionListener readSearchAL = new MenuItemActionListener(readSearch);
        MenuItemActionListener exitAL = new MenuItemActionListener(exit);
        fileMenu.addActionListener(fileMenuAL);
        readSort.addActionListener(readSortAL);
        readSearch.addActionListener(readSearchAL);
        exit.addActionListener(exitAL);

        // add items to menu bar
        menuBar.add(fileMenu);
        fileMenu.add(readSort);
        fileMenu.add(readSearch);
        fileMenu.add(exit);

        // create left button panel
        JPanel leftButtonPanel = new JPanel();
        leftButtonPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        GridBagLayout gridBagLayoutLeft = new GridBagLayout(); // gridbag layout
        leftButtonPanel.setLayout(gridBagLayoutLeft);
        leftButtonPanel.setPreferredSize(new Dimension(330, 350));
        leftButtonPanel.setMinimumSize(new Dimension(330, 350));
        GridBagConstraints leftButtonPanelConstraints = new GridBagConstraints();

        // add left buttons and labels to left panel
        leftButtonPanel.add(sortIntsButton);
        leftButtonPanel.add(sortIntsLabel);
        leftButtonPanel.add(addToBstButton);
        leftButtonPanel.add(addToBstLabel);
        leftButtonPanel.add(addToTreeSetButton);
        leftButtonPanel.add(addToTreeSetLabel);
        leftButtonPanel.add(addToPriorityQueueButton);
        leftButtonPanel.add(addToPriorityQueueLabel);
        leftButtonPanel.add(addToHashSetButton);
        leftButtonPanel.add(addToHashSetLabel);
        leftButtonPanel.add(addToArrayListButton);
        leftButtonPanel.add(addToArrayListLabel);
        leftButtonPanel.add(addToSortedArrayListButton);
        leftButtonPanel.add(addToSortedArrayListLabel);
        leftButtonPanel.add(addToArrayListButton);
        leftButtonPanel.add(addToArrayListLabel);
        leftButtonPanel.add(addToArrayButton);
        leftButtonPanel.add(addToArrayLabel);

        leftButtonPanelConstraints.weightx = 1;
        leftButtonPanelConstraints.weighty = 1;
        leftButtonPanelConstraints.fill = GridBagConstraints.NONE;
        leftButtonPanelConstraints.anchor = GridBagConstraints.LINE_START;

        // sortInt
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 0;
        leftButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutLeft.setConstraints(sortIntsButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 0;
        gridBagLayoutLeft.setConstraints(sortIntsLabel, leftButtonPanelConstraints);

        // addToBst
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 1;
        leftButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutLeft.setConstraints(addToBstButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 1;
        gridBagLayoutLeft.setConstraints(addToBstLabel, leftButtonPanelConstraints);

        // addToTreeSet
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 2;
        leftButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutLeft.setConstraints(addToTreeSetButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 2;
        gridBagLayoutLeft.setConstraints(addToTreeSetLabel, leftButtonPanelConstraints);

        // addToPriorityQueue
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 3;
        leftButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutLeft.setConstraints(addToPriorityQueueButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 3;
        gridBagLayoutLeft.setConstraints(addToPriorityQueueLabel, leftButtonPanelConstraints);

        // addToHashSet
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 4;
        leftButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutLeft.setConstraints(addToHashSetButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 4;
        gridBagLayoutLeft.setConstraints(addToHashSetLabel, leftButtonPanelConstraints);

        // addToaArrayList
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 5;
        leftButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutLeft.setConstraints(addToArrayListButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 5;
        gridBagLayoutLeft.setConstraints(addToArrayListLabel, leftButtonPanelConstraints);

        // addToSortedArrayList
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 6;
        leftButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutLeft.setConstraints(addToSortedArrayListButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 6;
        gridBagLayoutLeft.setConstraints(addToSortedArrayListLabel, leftButtonPanelConstraints);

        // addToArray
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 7;
        leftButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutLeft.setConstraints(addToArrayButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 7;
        gridBagLayoutLeft.setConstraints(addToArrayLabel, leftButtonPanelConstraints);

        // create right button panel
        JPanel rightButtonPanel = new JPanel();
        rightButtonPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        GridBagLayout gridBagLayoutRight = new GridBagLayout(); // gridbag layout
        rightButtonPanel.setLayout(gridBagLayoutRight);
        rightButtonPanel.setPreferredSize(new Dimension(330, 350));
        rightButtonPanel.setMinimumSize(new Dimension(330, 350));
        GridBagConstraints rightButtonPanelConstraints = new GridBagConstraints();

        sortIntsButton.addActionListener(new ButtonActionListener(sortIntsButton));
        addToBstButton.addActionListener(new ButtonActionListener(addToBstButton));
        addToTreeSetButton.addActionListener(new ButtonActionListener(addToTreeSetButton));
        addToPriorityQueueButton.addActionListener(new ButtonActionListener(addToPriorityQueueButton));
        addToHashSetButton.addActionListener(new ButtonActionListener(addToHashSetButton));
        addToArrayListButton.addActionListener(new ButtonActionListener(addToArrayListButton));
        addToSortedArrayListButton.addActionListener(new ButtonActionListener(addToSortedArrayListButton));
        addToArrayButton.addActionListener(new ButtonActionListener(addToArrayButton));
        searchIntsButton.addActionListener(new ButtonActionListener(searchIntsButton));
        searchBstButton.addActionListener(new ButtonActionListener(searchBstButton));
        searchTreesetButton.addActionListener(new ButtonActionListener(searchTreesetButton));
        searchPriorityQueueButton.addActionListener(new ButtonActionListener(searchPriorityQueueButton));
        searchHashSetButton.addActionListener(new ButtonActionListener(searchHashSetButton));
        searchArrayListButton.addActionListener(new ButtonActionListener(searchArrayListButton));
        searchSortedArrayListButton.addActionListener(new ButtonActionListener(searchSortedArrayListButton));
        searchArrayButton.addActionListener(new ButtonActionListener(searchArrayButton));

        // add buttons and labels to right panel
        rightButtonPanel.add(searchIntsButton);
        rightButtonPanel.add(searchIntsLabel);
        rightButtonPanel.add(searchBstButton);
        rightButtonPanel.add(searchBstLabel);
        rightButtonPanel.add(searchTreesetButton);
        rightButtonPanel.add(searchTreesetLabel);
        rightButtonPanel.add(searchPriorityQueueButton);
        rightButtonPanel.add(searchPriorityQueueLabel);
        rightButtonPanel.add(searchHashSetButton);
        rightButtonPanel.add(searchHashSetLabel);
        rightButtonPanel.add(searchArrayListButton);
        rightButtonPanel.add(searchArrayListLabel);
        rightButtonPanel.add(searchSortedArrayListButton);
        rightButtonPanel.add(searchSortedArrayListLabel);
        rightButtonPanel.add(searchArrayListButton);
        rightButtonPanel.add(searchArrayListLabel);
        rightButtonPanel.add(searchArrayButton);
        rightButtonPanel.add(searchArrayLabel);

        rightButtonPanelConstraints.weightx = 1;
        rightButtonPanelConstraints.weighty = 1;
        rightButtonPanelConstraints.fill = GridBagConstraints.NONE;
        rightButtonPanelConstraints.anchor = GridBagConstraints.LINE_START;

        // search sortInt
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 0;
        rightButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutRight.setConstraints(searchIntsButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 0;
        gridBagLayoutRight.setConstraints(searchIntsLabel, rightButtonPanelConstraints);

        // search bst
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 1;
        rightButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutRight.setConstraints(searchBstButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 1;
        gridBagLayoutRight.setConstraints(searchBstLabel, rightButtonPanelConstraints);

        // search treeSet
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 2;
        rightButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutRight.setConstraints(searchTreesetButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 2;
        gridBagLayoutRight.setConstraints(searchTreesetLabel, rightButtonPanelConstraints);

        // search priorityQueue
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 3;
        rightButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutRight.setConstraints(searchPriorityQueueButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 3;
        gridBagLayoutRight.setConstraints(searchPriorityQueueLabel, rightButtonPanelConstraints);

        // search hashSet
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 4;
        rightButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutRight.setConstraints(searchHashSetButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 4;
        gridBagLayoutRight.setConstraints(searchHashSetLabel, rightButtonPanelConstraints);

        // search arrayList
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 5;
        rightButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutRight.setConstraints(searchArrayListButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 5;
        gridBagLayoutRight.setConstraints(searchArrayListLabel, rightButtonPanelConstraints);

        // search sortedArrayList
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 6;
        rightButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutRight.setConstraints(searchSortedArrayListButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 6;
        gridBagLayoutRight.setConstraints(searchSortedArrayListLabel, rightButtonPanelConstraints);

        // search array
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 7;
        rightButtonPanelConstraints.gridwidth = 1;
        gridBagLayoutRight.setConstraints(searchArrayButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 7;
        gridBagLayoutRight.setConstraints(searchArrayLabel, rightButtonPanelConstraints);

        // create main button panel
        JPanel mainButtonPanel = new JPanel();
        mainButtonPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        BoxLayout boxLayoutMain = new BoxLayout(mainButtonPanel, BoxLayout.X_AXIS);
        mainButtonPanel.setLayout(boxLayoutMain);
        mainButtonPanel.add(leftButtonPanel);
        mainButtonPanel.add(rightButtonPanel);
        // GridBagConstraints gridBagConstraintsMain = new GridBagConstraints();

        // create main panel
        JPanel mainPanel = new JPanel();
        BorderLayout borderLayoutMain = new BorderLayout();
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        mainPanel.setLayout(borderLayoutMain);
        mainPanel.add(menuBar, BorderLayout.NORTH);
        mainPanel.add(mainButtonPanel, BorderLayout.CENTER);

        // initially set buttons as disabled
        sortIntsButton.setEnabled(false);
        addToBstButton.setEnabled(false);
        addToTreeSetButton.setEnabled(false);
        addToPriorityQueueButton.setEnabled(false);
        addToHashSetButton.setEnabled(false);
        addToArrayListButton.setEnabled(false);
        addToSortedArrayListButton.setEnabled(false);
        addToArrayButton.setEnabled(false);

        searchIntsButton.setEnabled(false);
        searchBstButton.setEnabled(false);
        searchTreesetButton.setEnabled(false);
        searchPriorityQueueButton.setEnabled(false);
        searchHashSetButton.setEnabled(false);
        searchArrayListButton.setEnabled(false);
        searchSortedArrayListButton.setEnabled(false);
        searchArrayButton.setEnabled(false);

        // add content of frame as mainPanel,validate, and make frame visible
        f.setContentPane(mainPanel);
        f.validate();
        f.setVisible(true);
    }

    public class buttonMethods {

        private static void selectionSort() {

            /// clear int array
            sortedValues = new int[sortValues.length];

            // copy values of sortValues to sortedValues
            for (int copy = 0; copy < sortValues.length; copy++) {
                sortedValues[copy] = sortValues[copy];
            }

            System.out.println("copying complete");
            // cpature time before selection sort
            // selection sort

            for (int i = 0; i < sortedValues.length; i++) {
                // minimum element in unsorted array
                int minIndex = i;
                for (int j = i + 1; j < sortedValues.length; j++) {
                    if (sortedValues[j] < sortedValues[minIndex])
                        minIndex = j;
                }
                // if (minIndex != i) { // swap sortedValues[min] and sortedValues[i]
                int temp = sortedValues[minIndex];
                sortedValues[minIndex] = sortedValues[i];
                sortedValues[i] = temp;
                // }
            }
            // capture time after selection sort

            sortIntIsClicked = true;

        }

        private static int searchInts() {
            int[] sortedValuesSearched = new int[sortedValues.length];
            int count = 0;
            // System.out.println(sortedValuesSearched.length);

            Arrays.sort(searchValues);

            // binarySearch(sortedValues, searchValues[0]);
            for (int i = 0; i < sortedValues.length; i++) {
                int top = sortedValues.length - 1;
                int bottom = 0;
                while (bottom <= top) {
                    int mid = bottom + (top - bottom) / 2;
                    if (searchValues[i] < sortedValues[mid]) {
                        top = mid - 1;
                    } else if (searchValues[i] > sortedValues[mid]) {
                        bottom = mid + 1;
                    } else {
                        count++;
                        break;
                    }
                }

                /*
                 * if (binarySearch(sortedValues, searchValues[i])) {
                 * count++;
                 * sortedValuesSearched[i] = searchValues[i]; // test to make sure, not
                 * // neccesary
                 */

            }

            // if (binarySearch(sortedValues, searchValues[i])) {
            // count++;
            // sortedValuesSearched[i] = searchValues[i]; // test to make sure, not
            // neccesary
            // }

            // }
            System.out.println("done");

            // for (int sort : sortedValuesSearched) {
            // System.out.println(sort);
            // }
            int numOfValuesFound = count;
            // sortedValuesSearched.length;

            return numOfValuesFound;

        }

        private static boolean binarySearch(int[] array, int key) {
            // USE A BINARY SEARCH
            int bottom = 0;
            int top = array.length - 1;
            while (bottom <= top) {
                int middle = (bottom + top) / 2;
                if (key < array[middle])
                    top = middle - 1;
                else if (key > array[middle])
                    bottom = middle + 1;
                else
                    return true;
            }
            return false;
        }

        private static void addToBinarySearchTree() {
            // FIX LATER!!!!!!!!
            // add values to binary search tree using node functions and code from prog 5

            bst = new choe_BinarySearchTree();
            for (int i = 0; i < sortValues.length; i++) {
                bst.insertNode(new Node(sortValues[i]));
            }
        }

        private static int searchBinarySearchTree() {

            int count = 0;

            for (int i = 0; i < searchValues.length; i++) {
                Node n = bst.getNode(bst.getRoot(), searchValues[i]);
                if (n != null) {
                    count++;
                }
            }

            return count;

        }

        private static void addToTreeSet() {
            // clear treeset
            // treeSetValues.clear();
            System.out.println("hello");
            // add sortValues data into the treeset
            for (int i = 0; i < sortValues.length; i++) {
                treeSetValues.add(sortValues[i]);
            }

            // for (int t : treeSetValues) {
            // System.out.println(t);
            // }

        }

        private static int searchTreeSet() {
            /*
             * Iterator<Integer> it = treeSetValues.iterator();
             * int[] treeSetSearched = new int[searchValues.length];
             * for(int i = 0; i < searchValues.length; i++){
             * while(it.hasNext()){
             * int currentValue = it.next();
             * 
             * if(currentValue == searchValues[i]){
             * treeSetSearched[i] = searchValues[i];
             * }
             * }
             * }
             */
            int count = 0;
            // int[] treeSetSearched = new int[searchValues.length];
            for (int i = 0; i < searchValues.length; i++) {
                if (treeSetValues.contains(searchValues[i])) {
                    // treeSetSearched[i] = searchValues[i];
                    count++;
                }
            }

            int numOfValuesFound = count;
            return numOfValuesFound;
        }

        private static void addToHashSet() {
            // clear hashSet
            hashSetValues.clear();

            // add sortValues into hashset
            for (int i = 0; i < sortValues.length; i++) {
                hashSetValues.add(sortValues[i]);
            }

        }

        private static int searchHashSet() {

            // int[] hashSetSearched = new int[searchValues.length];
            int count = 0;
            for (int search : searchValues) {
                if (hashSetValues.contains(search)) {
                    count++;
                }
            }

            int numOfValuesFound = count;

            return numOfValuesFound;
        }

        private static void addToPriorityQueue() {
            // clear prioqueue
            priorityQueueValues.clear();

            // add prioqueue values
            for (int sort : sortValues) {
                priorityQueueValues.add(sort);
            }
            // System.out.println(priorityQueueValues);
        }

        private static int searchPriorityQueue() {

            int count = 0;
            // int[] priorityQueueSearched = new int[searchValues.length];

            for (int search : searchValues) {
                if (priorityQueueValues.contains(search)) {
                    count++;
                }
            }

            int numOfValuesFound = count;
            /*
             * for (int prio : priorityQueueSearched) {
             * System.out.println(prio);
             * }
             */
            return numOfValuesFound;
        }

        private static void addToArrayList() {
            // clear arrayList
            arrayListValues.clear();

            for (int sort : sortValues) {
                arrayListValues.add(sort);
            }

        }

        private static int searchArrayList() {

            // int[] arrayListSearched = new int[searchValues.length];
            int count = 0;

            for (int search : searchValues) {
                if (arrayListValues.contains(search)) {
                    count++;
                }
            }

            int numOfValuesFound = count;

            return numOfValuesFound;
        }

        private static void addToSortedArrayList() {
            // clear sortedArrayList
            sortedArrayListValues.clear();

            for (int sort : sortValues) {
                sortedArrayListValues.add(sort);
            }

            Collections.sort(sortedArrayListValues);

        }

        private static int searchSortedArrayList() {

            // int[] sortedArrayListSearched = new int[arrayListValues.size()];
            int count = 0;
            for (int search : searchValues) {
                if (Collections.binarySearch(sortedArrayListValues, search) >= 0) {
                    count++;
                }
            }

            int numOfValuesFound = count;

            return numOfValuesFound;
        }

        private static void addToArray() {
            // clear array
            unsortedValues = new int[sortValues.length];

            for (int i = 0; i < sortValues.length; i++) {
                unsortedValues[i] = sortValues[i];
            }

        }

        private static int searchArray() {
            // int[] unsortedValuesSearched = new int[unsortedValues.length];
            int count = 0;

            for (int i = 0; i < searchValues.length; i++) {
                for (int j = 0; j < unsortedValues.length; j++) {
                    if (searchValues[i] == unsortedValues[j]) {
                        count++;
                    }
                }
            }
            int numOfValuesFound = count;

            return numOfValuesFound;
        }

        static void readData(String filename, boolean readSortValues) {
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
                String inn;

                ArrayList<Integer> placeholder = new ArrayList<>();

                while ((inn = input.readLine()) != null) {
                    int sub = Integer.parseInt(inn);
                    placeholder.add(sub);
                }

                if (readSortValues == true) {
                    sortIntsButton.setEnabled(true);
                    addToBstButton.setEnabled(true);
                    addToTreeSetButton.setEnabled(true);
                    addToPriorityQueueButton.setEnabled(true);
                    addToHashSetButton.setEnabled(true);
                    addToArrayListButton.setEnabled(true);
                    addToSortedArrayListButton.setEnabled(true);
                    addToArrayButton.setEnabled(true);

                    sortValues = new int[placeholder.size()];
                    for (int i = 0; i < sortValues.length; i++) {
                        sortValues[i] = placeholder.get(i);
                    }
                } else {
                    searchValues = new int[placeholder.size()];
                    readSearchIsClicked = true;
                    System.out.println("clicked readSearch");

                    if ((sortIntIsClicked)) {
                        searchIntsButton.setEnabled(true);
                    }
                    if (addToBstIsClicked) {
                        searchBstButton.setEnabled(true);
                    }
                    if (addToTreeSetIsClicked) {
                        searchTreesetButton.setEnabled(true);
                    }
                    if (addToPriorityQueueIsClicked) {
                        searchPriorityQueueButton.setEnabled(true);
                    }
                    if (addToHashSetIsClicked) {
                        searchHashSetButton.setEnabled(true);
                    }
                    if (addToArrayListIsClicked) {
                        searchArrayListButton.setEnabled(true);
                    }
                    if (addToSortedAraryListIsClicked) {
                        searchSortedArrayListButton.setEnabled(true);
                    }
                    if (addToArrayIsClicked) {
                        searchArrayButton.setEnabled(true);
                    }
                    searchValues = new int[placeholder.size()];
                    for (int i = 0; i < sortValues.length; i++) {
                        searchValues[i] = placeholder.get(i);
                    }
                }

                /*
                 * if (readSortValues == true) {
                 * sortValues[i] = Integer.parseInt(inn);
                 * System.out.println("readdata complete");
                 * 
                 * } else {
                 * searchValues[i] = Integer.parseInt(inn);
                 * }
                 * i++;
                 */

                input.close();

                System.out.println("reading complete");

                // System.out.println("readdata complete");
            } catch (Exception e) {

            }
        }
    }
}