class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int row0 = 0, col0 = 0;
        for (char ch : target.toCharArray()) {
            int row = (ch - 'a') / 5;
            int col = (ch - 'a') % 5;
            // if (row0 == row && col0 == col) {
            //     sb.append('!');
            // } else {
                // if (ch == 'z') {
                //     int rowDiff = row - row0;
                //     // System.out.println(rowDiff);
                //     sb.append("D".repeat(rowDiff - 1));
                //     //move left if possible
                //     sb.append("L".repeat(Math.abs(col - col0)));
                //     sb.append("D");//for case z
                // } else {
                //order LDUR
                if(col0 > col) {
                    sb.append("L".repeat(col0 - col));
                }
                if (row > row0) {
                    sb.append("D".repeat(row - row0));
                } 
                if(row0 > row) {
                    sb.append("U".repeat(row0 - row));
                }
                if (col > col0) {
                    sb.append("R".repeat(col - col0));
                } 
                // }
                sb.append('!');
            // }
            row0 = row;
            col0 = col;
        }
        return sb.toString();
    }
}