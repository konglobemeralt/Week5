package assignments.product;

import static java.lang.System.out;

/*
 *  Representing the man
 */
public class Man {
    private int stage = 0;
    private int life = 8;
    private final String[] parts = {
            "---|\n",
            "   |\n",
            "   O\n",
            "  /",
            "|",
            "\\\n",
            "  /",
            " \\\n",
    };


    public void nextStage() {
        this.stage++;
    }

    public boolean isDead()  {
        return this.stage >=  this.life;
    }

    public int getStage() {
        return this.stage;
    }

    public void plot() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < stage) {
            sb.append(parts[i]);
            i++;
        }
        out.println(sb.toString());

    }
}
