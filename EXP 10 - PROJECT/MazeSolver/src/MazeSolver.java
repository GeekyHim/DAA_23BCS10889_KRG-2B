public class MazeSolver {

    static int rows, cols;

    public static void main(String[] args) {
        System.out.println("=== MAZE SOLVER ===");
        System.out.println("S = Start, E = End, | = Wall, . = Path\n");

        // maze
        char[][] maze = {
                {'S', '.', '.', '|', '.', '.', '.', '.', '.', '.'},
                {'|', '|', '.', '|', '.', '|', '|', '|', '|', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '|', '.'},
                {'.', '|', '|', '|', '|', '|', '.', '|', '|', '.'},
                {'.', '|', '.', '.', '.', '|', '.', '.', '.', '.'},
                {'.', '|', '.', '|', '.', '|', '|', '|', '|', '.'},
                {'.', '|', '.', '|', '.', '.', '.', '.', '|', '.'},
                {'.', '|', '.', '|', '|', '|', '|', '.', '|', '.'},
                {'.', '.', '.', '.', '.', '.', '|', '.', '.', 'E'},
                {'|', '|', '|', '|', '|', '|', '|', '|', '|', '|'}
        };

        rows = maze.length;
        cols = maze[0].length;

        System.out.println("--- Original Maze ---");
        printMaze(maze);

        // starting position (S)
        int startRow = -1, startCol = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        System.out.println("\nSolving maze...");
        boolean pathFound = solveMaze(maze, startRow, startCol);

        if (pathFound)
            System.out.println("\nPath Found!");
        else
            System.out.println("\nNo Path Found!");

        System.out.println("\n--- Final Maze ---");
        printMaze(maze);
    }

    // Recursive DFS Maze Solver

    public static boolean solveMaze(char[][] maze, int row, int col) {
        // base case
        if (maze[row][col] == 'E') return true;


        if (maze[row][col] == '.' || maze[row][col] == 'S') {
            char original = maze[row][col];
            maze[row][col] = '*'; // mark as part of path

            // Move UP
            if (isValidMove(maze, row - 1, col)) {
                if (solveMaze(maze, row - 1, col)) return true;
            }

            // Move DOWN
            if (isValidMove(maze, row + 1, col)) {
                if (solveMaze(maze, row + 1, col)) return true;
            }

//            // Move RIGHT
//            if (isValidMove(maze, row, col + 1)) {
//                if (solveMaze(maze, row, col + 1)) return true;
//            }

            // Mai right phele explore kar raha hu ya baad me isse path ka phrk pd raha hai since
            // more than one paths are existing

            // Move LEFT
            if (isValidMove(maze, row, col - 1)) {
                if (solveMaze(maze, row, col - 1)) return true;
            }

            // Move RIGHT
            if (isValidMove(maze, row, col + 1)) {
                if (solveMaze(maze, row, col + 1)) return true;
            }


            // Backtrack
            maze[row][col] = original;
        }

        return false;
    }


    public static boolean isValidMove(char[][] maze, int row, int col) {
        return row >= 0 && row < rows &&
                col >= 0 && col < cols &&
                (maze[row][col] == '.' || maze[row][col] == 'E');
    }


    public static void printMaze(char[][] maze) {
        for (char[] line : maze) {
            for (char cell : line) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
