package edu.sjsu.whiteboard.models;

import edu.sjsu.whiteboard.shapes.DShape;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * @author Yulan Jin yulan.jin@sjsu.edu
 * CS 151 Term Project - Whiteboard
 */

/**
 * TableModel class contains all the necessary methods for whiteboard table. Uses Vector class for data storage
 */

public class TableModel extends AbstractTableModel {

    private String[] columnNames = { "X", "Y", "Width", "Height" };
    private ArrayList<DShape> shapeList;

    public TableModel( ArrayList<DShape> shapeList){
        this.shapeList = shapeList;
    }

    public TableModel getTableModel(){
        return this;
    }

    public ArrayList<DShape> getShapeList() {
        return shapeList;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return shapeList.size();
    }

    @Override
    public Object getValueAt(int row, int col) {

        // Return X coord
        if(col == 0){
            if(shapeList.get(row).getDShapeModel() instanceof DLineModel){
                return "Start X: "+((DLineModel)shapeList.get(row).getDShapeModel()).getP1().x;

            }
            else{
                return shapeList.get(row).getDShapeModel().getX();
            }
        }

        // Return Y coord
        else if(col == 1){
            if(shapeList.get(row).getDShapeModel() instanceof DLineModel){
                return "Start Y: "+((DLineModel)shapeList.get(row).getDShapeModel()).getP1().y;

            }
            else{
                return shapeList.get(row).getDShapeModel().getY();
            }
        }

        // Return Width
        else if(col == 2){
            if(shapeList.get(row).getDShapeModel() instanceof DLineModel){
                return "End X: "+((DLineModel)shapeList.get(row).getDShapeModel()).getP2().x;

            }
            else{
                return shapeList.get(row).getDShapeModel().getWidth();
            }
        }

        // Return Height
        else if(col == 3){
            if(shapeList.get(row).getDShapeModel() instanceof DLineModel){
                return "End Y: "+((DLineModel)shapeList.get(row).getDShapeModel()).getP2().y;

            }
            else{
                return shapeList.get(row).getDShapeModel().getHeight();
            }
        }

        return shapeList.get(row).getDShapeModel().getHeight();
    }

    public String getColumnName(int col){
        return columnNames[col];
    }
    public Class getColumnClass(int c){
        return getValueAt(0,c).getClass();
    }



}
