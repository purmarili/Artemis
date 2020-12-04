package LES_03;



class Robot {
    String name;
    String color;

    Robot (){
        name = "Robo";
        color = "Witeli";
        System.out.println();
    }

    Robot (String name){
        this.name = name;
        color = "Witeli";
    }

    Robot (String name, String color){
        this.name = name;
        this.color = color;
    }

}
