package ca.simulations;

import ca.helpers.NeighboringType;
import ca.helpers.NeighborsHelper;
import ca.model.Cell;
import ca.model.CellShape;
import ca.model.Grids.Grid;
import ca.model.Grids.GridBase;
//import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.List;

public abstract class Simulation {
    GridBase grid;
    NeighborsHelper neighborsHelper;
    NeighboringType type;

    //TODO: change the cocnstructor usage to separate view and model
    public Simulation(GridBase grid) {
        neighborsHelper = new NeighborsHelper();
        this.type = NeighboringType.ALL;
        this.grid = grid;
    }

    public Simulation(int rowNum, int colNum, List<Integer> initialStates, CellShape shape) {
        this.grid = new Grid(rowNum, colNum, initialStates, shape);
        neighborsHelper = new NeighborsHelper(shape);
        this.type = NeighboringType.ALL;
    }

    /**
     * This method tells the number of neighbors that have a
     * specific state. It can be either all eight neighbors or
     * only NSWE neighbors by passing in different {@code mode}.
     * @param r         an int of the row position of this cell
     * @param c         an int of the col position of this cell
     * @param type      the number of neighbors chosen, ("EIGHT"/"NSWE")
     * @param state     an int representing the state to find
     * @return          the number of neighbors have {@code state}
     */
    //TODO: change method headings
    public int getNeighborStateNumber(int r, int c, NeighboringType type, int state) {
       List<Cell> neighbors = getNeighboringCellsOfState(r, c, type);
        int num = 0;
        for (Cell cell: neighbors) {
            if (cell.getState() == state) {
                num++;
            }
        }
        return num;
    }

    // TODO: change method heads in other classes
    private List<Cell> getNeighboringCellsOfState(int r, int c, NeighboringType type) {
        List<Cell> neighbors;
        try {
            switch (type) {
                case ALL:
                    neighbors = grid.getNeighborsByIndex(r, c, neighborsHelper.getAllRow(),
                            neighborsHelper.getAllCol());
                    break;
                case NSEW:
                    neighbors = grid.getNeighborsByIndex(r, c, neighborsHelper.getNSEWRow(),
                            neighborsHelper.getNSEWCol());
                    break;
                default:
                    neighbors = new ArrayList<>();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return neighbors;
    }

    /**
     * Returns all the neighbours with a specified state
     * @param r
     * @param c
     * @param state
     * @return
     */
    public List<Cell> getNeighboringCellsWithState(int r, int c, int state){
        List<Cell> ret = new ArrayList<>();
        List<Cell> neighbors = grid.getNeighborsByIndex(r, c, neighborsHelper.getNSEWRow(), neighborsHelper.getNSEWCol());
        for (Cell item : neighbors){
            if (item.getState() == state) {
                ret.add(item);
            }
        }
        return ret;
    }

    // TODO: check to see why need cell access
    public List<Cell> getCellOfState(int state) {
        List<Cell> cells = grid.getAllCells();
        List<Cell> ret = new ArrayList<>();

        for (Cell cell: cells) {
            if (cell.getState() == state) {
                ret.add(cell);
            }
        }
        return ret;
    }

    public int cellStateTotal(int state) {
        List<Cell> allCells = getCellOfState(state);
        return allCells.size();
    }

    public void runOneStep() {
        Grid gridNextGen = new Grid((Grid) grid);
        for (int r = 0; r < grid.getNumOfRows(); r++) {
            for (int c = 0; c < grid.getNumOfColumns(); c++) {
                gridNextGen.setCellState(r, c, determineCellState(r, c));
            }
        }
        grid = additionalActions(gridNextGen);
    }

    // TODO: delete this and check for dependency
    public GridBase getGrid() {
        return grid;
    }

    public int getNumOfRows() {
        return grid.getNumOfRows();
    }

    public int getNumOfCols() {
        return grid.getNumOfColumns();
    }

    public void setNumOfRows(int numOfRow) {
        grid.setNumOfRows(numOfRow);
    }

    public void setNumOfCols(int numOfCol) {
        grid.setNumOfColumns(numOfCol);
    }

    protected Grid additionalActions(Grid gridNextGen){
        return gridNextGen;
    }
    protected abstract int determineCellState(int r, int c);
}
