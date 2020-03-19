package com.shd.data;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public class Student {
    public  enum GradeLevel  {One, Two, Three ,Four ,Five, Six,Seven,Eight,Nine,Ten,Elevn}
    private  Optional<Integer> lisId;
    private  String name;
    private  int age;
    private  int score;
    private String idntStr ;
    private  enum Gender {Female, Male}
    private Gender gender ;
    private GradeLevel gradeLevel ;
    private String schoolName ;
    private int recordNu ;
    public void setLisId(Optional<Integer> lisId) {
        this.lisId = lisId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setGender(Gender gender) {this.gender = gender;}
    public String getIdntStr() {return idntStr;}
    public void setIdntStr(String idntStr) {this.idntStr = idntStr;}
    public GradeLevel getGradeLevel() { return gradeLevel;}
    public String getGradeLevelStr() {return gradeLevel.toString();}
    public void setGradeLevel(GradeLevel gradeLevel) {this.gradeLevel = gradeLevel;}
    public String getSchoolName() {return schoolName; }
    public void setSchoolName(String schoolName) {this.schoolName = schoolName;}
    public int getAge() {return age;}
    public String getName() {return name; }
    public int getScore() { return score;}
    public Gender getGender() {return gender;}
    public int getRecordNu() {return recordNu++;}
    public void setRecordNu(int recordNu) {this.recordNu = recordNu;}
    public Optional<Integer> getLisId() { return lisId; }

    public Student() {

    }

    public Student(String namei,Gender genderi, int agei, GradeLevel gradeLeveli,int recordNui, String schoolNamei, int scorei, Integer lisIdi) {
        //idnt = UUID.nameUUIDFromBytes((namei+"L" + String.valueOf(lisId)).getBytes()).toString().replaceAll("-","");
        idntStr = UUID.nameUUIDFromBytes(namei.getBytes()).toString().replaceAll("-", "");
        name = namei;
        gender=genderi ;
        age = agei;
        gradeLevel = gradeLeveli;
        recordNu=recordNui;
        schoolName=schoolNamei;
        score = scorei;
        lisId = Optional.ofNullable(lisIdi);
    }
    public String getIdnStr() {
        return idntStr;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", grade='" + gradeLevel + '\'' +
                ", idntStr='" + idntStr + '\'' +
                ", gender=" + gender + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", recordNu='" + recordNu +
                ",lisId=" + lisId +'\'' +
                '}';
    }
    public   List<Student>  makeList1() {
        //Optional<Integer> lisIdInp1 = Optional.of(1);
        int lisIdInp1 = 1;
        List<Student>  studentLis1 = Arrays.asList(
                new Student("GrandMary", Gender.Female, 6, GradeLevel.Six,1,"Erindale", 90, lisIdInp1),
                new Student("Daniel", Gender.Male, 7, GradeLevel.Seven, 2,"Brookmede", 91, lisIdInp1),
                new Student("David", Gender.Male, 8, GradeLevel.Eight,3, "Whitehead", 95, null),
                new Student("Madison", Gender.Female, 9, GradeLevel.Nine,4, "HolyNameOfMary", 95, lisIdInp1),
                new Student("Alexandra", Gender.Female, 10, GradeLevel.Ten,5, "YoungMinds", 93, lisIdInp1),
                new Student("Katherine", Gender.Female, 11, GradeLevel.Elevn, 6,"StChristopher", 97, lisIdInp1),
                new Student("Caroline", Gender.Female, 14, GradeLevel.Three,7, "Tecumseh", 90, lisIdInp1),
                new Student("Matthew", Gender.Male, 14, GradeLevel.Two,8,"RiverSide", 93, lisIdInp1),
                new Student("Leon", Gender.Male, 14, GradeLevel.Ten,9, "RiverSide", 97, lisIdInp1),
                new Student("Natalie", Gender.Female, 11, GradeLevel.Five, 10,"Clarkson", 90, lisIdInp1),
                new Student("Sophie", Gender.Female, 15, GradeLevel.One,11, "GreenGlad", 91, lisIdInp1),
                new Student("George", Gender.Male, 14, GradeLevel.Four, 12,"LynnEagle", 98, lisIdInp1)
        );
  return studentLis1 ;
    }
    public   List<Student>  makeList2() {
        //Optional<Integer> lisIdInp2 = Optional.of(2);
        int lisIdInp2 =2 ;
        return Arrays.asList(
                new Student("GrandMary", Gender.Female, 6, GradeLevel.Six,1,"Erindale", 92, lisIdInp2),
                new Student("Daniel", Gender.Male, 7, GradeLevel.Seven, 2,"Brookmede", 92, lisIdInp2),
                new Student("David", Gender.Male, 8, GradeLevel.Eight,3, "Whitehead", 95, null),
                new Student("Madison", Gender.Female, 9, GradeLevel.Nine,4, "HolyNameOfMary", 95, lisIdInp2),
                new Student("Alexandra", Gender.Female, 10, GradeLevel.Ten,5, "YoungMinds", 93, lisIdInp2),
                new Student("Katherine", Gender.Female, 11, GradeLevel.Elevn, 6,"StChristopher", 97, lisIdInp2),
                new Student("Caroline", Gender.Female, 14, GradeLevel.Three,7, "Tecumseh", 90, lisIdInp2),
                new Student("Matthew", Gender.Male, 14, GradeLevel.Two,8,"RiverSide", 93, lisIdInp2),
                new Student("Leon", Gender.Male, 14, GradeLevel.Ten,9, "RiverSide", 97, lisIdInp2),
                new Student("Natalie", Gender.Female, 11, GradeLevel.Five, 10,"Clarkson", 90, lisIdInp2),
                new Student("Sophie", Gender.Female, 15, GradeLevel.One,11, "GreenGlad", 91, lisIdInp2),
                new Student("George", Gender.Male, 14, GradeLevel.Four, 12,"LynnEagle", 98, lisIdInp2)
        );
    }

}