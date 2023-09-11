public class sodokuSlove implements SudokuSolver {
    private int [][] matrix; 
    public sodokuSlove(){
        this.matrix = new int[9][9];

    }
    @Override
    public boolean solve() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean legal(int digit, int row, int col) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void set(int row, int col, int digit) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void remove(int row, int col) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        matrix = new int[9][9];
        
    }

    @Override
    public void setMatrix(int[][] matrix) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int[][] getMatrix() {
        // TODO Auto-generated method stub
        return matrix;
    }
    
    public void printMaxtrix(){
        for(int i = 0; i < matrix.length; i ++){
            for (int s = 0; s < matrix[i].length; s++){
                System.out.print(matrix[i][s]);
                System.out.print("  ");
            }
            System.out.println();
            //System.out.println();
        }

    }

    public static void main(String[] args) {
        sodokuSlove Gmodel = new sodokuSlove();
        Gmodel.printMaxtrix();
    }
    
}
