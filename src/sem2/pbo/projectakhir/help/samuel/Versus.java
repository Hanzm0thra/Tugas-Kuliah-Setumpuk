package sem2.pbo.projectakhir.help.samuel;

import java.util.ArrayList;
import java.util.Random;

public class Versus {
    Team[][] arrRecordPlaying = new Team[2][2];
    ArrayList<Team> versusTeam = new ArrayList<>();

    public void teamSkorInit(ArrayList<Team> teams){
        versusTeam.addAll(teams);
        Random random = new Random();

        for (int x = 0; x < versusTeam.size(); x++) {
            for (int y = 0; y < versusTeam.size(); y++) {
                    int skor1 = random.nextInt(10) + 1;
                    int skor2 = random.nextInt(10) + 1;
                    int skorTeam1 = 0;
                    int skorTeam2 = 0;

                    if(skor1 > skor2){
                        skorTeam1 = skorTeam1 + 3;
                    }else if(skor1 < skor2){
                        skorTeam2 = skorTeam2 + 3;
                    }else {
                        skorTeam1 = skorTeam1 + 1;
                        skorTeam2 = skorTeam2 + 1;
                    }

                    if (x != y && arrRecordPlaying[x][y] == null ) {
                        arrRecordPlaying[x][y] = new Team(
                                versusTeam.get(x).nama(),
                                versusTeam.get(x).region(),
                                versusTeam.get(x).waktuTerbentuk(),
                                versusTeam.get(x).tier(),
                                skorTeam1
                        );

                        arrRecordPlaying[y][x] = new Team(
                                versusTeam.get(y).nama(),
                                versusTeam.get(y).region(),
                                versusTeam.get(y).waktuTerbentuk(),
                                versusTeam.get(y).tier(),
                                skorTeam2
                        );
                    }
            }
        }
    }
}
