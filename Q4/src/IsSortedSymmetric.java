import java.util.Arrays;

/**
 * Created by manojpolisetti on 05/10/15.
 */
public class IsSortedSymmetric {
    int coma = 0;
    int colon = 0;
    public boolean isSortedSymmetric(String s) {
        String[] split1 = s.split(";");
        String[][] res = new String[split1.length][split1[0].split(",").length];
        for (int i = 0; i < split1.length; i++) {
            res[i] = split1[i].split(",");
        }
        int[] c = new int[res.length];
        for(int j = 0; j < res.length; j++) {
            c[j] = Integer.parseInt(res[0][j]);
        }
        Arrays.sort(c);

    }
}
