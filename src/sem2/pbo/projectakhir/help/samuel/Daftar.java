package sem2.pbo.projectakhir.help.samuel;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Daftar{
    ArrayList<Team> team = new ArrayList<>();
    ArrayList<MemberTeam> member = new ArrayList<>();

    public ArrayList<MemberTeam> getMember() {
        return member;
    }

    public ArrayList<Team> getTeam() {
        return team;
    }
    public void setTeam( String nama, String region, String waktuTerbentuk, int tier){
        team.add(new Team(nama, region, waktuTerbentuk, tier, 0));
    }
    public void setMember( String nama, String nickName, String country, String team){
        member.add(new MemberTeam(nama, nickName, country, team));
    }
    private ArrayList<MemberTeam> getMemberByTeam(String namaTeam){
        ArrayList<MemberTeam> filterMember = new ArrayList<>();
        member.stream().filter(memberTeam -> memberTeam.team().equals(namaTeam))
                .map(filterMember::add)
                .collect(Collectors.toList());
        return filterMember;
    }

    public void RegistrasiTeam(){
        System.out.println("================REGISTRASI TEAM================");
        System.out.println();
        for(Team tm : getTeam()){
            System.out.println("================TEAM TERDAFTAR================");
            System.out.println("" +
                    "Nama Team        : " + tm.nama() +
                    "\nRegion           : " + tm.region() +
                    "\nWaktu Terbentuk  : " + tm.waktuTerbentuk() +
                    "\nTier             : " + tm.tier());
            System.out.println("================MEMBER TEAM================");
            for(MemberTeam mb : getMemberByTeam(tm.nama())){
                System.out.println("" +
                        "Nama Member   : " + mb.nama() +
                        "\nNick Name     : " + mb.nickName() +
                        "\nCountry       : " + mb.country() +
                        "\nTeam          : " + mb.team());
                System.out.println();
            }
        }
        System.out.println("================REGISTRASI TEAM================");
    }
}
