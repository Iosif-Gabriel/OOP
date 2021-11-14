import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        List<String> list1=new ArrayList<String>();

        StringBuilder str=new StringBuilder();
        StringBuilder str1=new StringBuilder();
        StringBuilder str2=new StringBuilder();
        StringBuilder num=new StringBuilder();

        list.add("sdad");
        list.add("asds");
        list.add("fbsd");
        list.add("mfds");
        list.add("gdfss");

        System.out.println(list);
        extractFirstLetter(list, str);//1
        removeOddLength(list);//2
        listToUpper(list);//3
        lowerCaseNewList(list, list1);//6 5


       Map<String, String> map1=new HashMap<>();
       map1.put("red","apple");
       map1.put("yellow","banana");
       map1.put("purple","plum");
       map1.put("orange","tangerine");
       mapstoStringB(str1, map1);//4

       joined234(list, str2);//7



        //8
        //Infinte stream
        System.out.println("8.infinte stream:");
        Stream<Integer> infStream=Stream.iterate(0,i->i+2);
        List<Integer> sum1=infStream
                .limit(100)
                .collect(Collectors.toList());

        System.out.println(sum1);
        //


        //9
        List<Integer> numbers=new ArrayList<Integer>();
        numbers.add(122);
        numbers.add(323);
        numbers.add(4123);
        numbers.add(123321);
//        numbers.stream().forEach((n)->{
//            if(pal(n).isEmpty()){
//                numbers.remove(n);
//            }
//        });


        //10
        List<Employees> listang=new ArrayList<Employees>();
        Employees ang=new Employees("viorel",22,123.00);
        Employees ang1=new Employees("viorel",22,153.00);
        Employees ang2=new Employees("viorel",22,142.00);
        listang.add(ang);
        listang.add(ang1);
        listang.add(ang2);

        double sum=listang.stream().mapToDouble(Employees::getSalary).sum();
        System.out.println("10.Aveage salary of all employees: "+sum/listang.size());


        //11
        List<Courses> cours=new ArrayList<Courses>();
        Courses co=new Courses("Math");
        Courses co1=new Courses("Algebra");
        Courses co2=new Courses("POO");
        cours.add(co);
        cours.add(co1);
        cours.add(co2);
        Students stu=new Students("Raul",7.32,cours);
        Students stu2=new Students("Radu",7.33,cours);
        Students stu3=new Students("Gigi",6.32,cours);

        Map<String,Integer> uni=new HashMap<>();
        uni.put(stu.getName(),cours.size());
        uni.put(stu2.getName(),cours.size());
        uni.put(stu3.getName(),cours.size());
        System.out.println("11."+uni);

        //12
        List<Cars> carList=new ArrayList<Cars>();
        Cars car1=new Cars("BMW", 2021,"BLUE",41233.123);
        Cars car2=new Cars("Mercedes",2019,"Black",1241231.1231);
        Cars car3=new Cars("Audi",2022,"Gray",12412343.123);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carsSortedPrice(carList);

        //13
        fibonacci(10);


    }

    private static void fibonacci(int limit) {
        System.out.println("13.Fibonacci");
      int sum= Stream.iterate(new int[]{0,1},p->new int[]{p[1],p[0]+p[1]})
            .limit(limit)
                .map(p->p[0])
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum Fibonacci:"+sum);
    }

    private static void carsSortedPrice(List<Cars> carList) {
        System.out.println("12.Cars sorted by price:");
        List<Cars> priceCars= (List<Cars>) carList.stream()
        .sorted(Comparator.comparing(Cars::getPrice))
        .collect(Collectors.toList());
        carList.forEach((n)->{
            System.out.println(n.getBrand()+" "+n.getPrice());
        });
    }

    private static void mapstoStringB(StringBuilder str1, Map<String, String> map1) {
        System.out.println("4."+map1);
        map1.forEach((key, value)->{
            str1.append(key);
            str1.append("=");
            str1.append(value);
            str1.append(", ");
        });
        System.out.println(str1);
    }

    private static Optional<Integer> pal(Integer a){
        StringBuilder b=new StringBuilder(a.toString());
        StringBuilder c=new StringBuilder(a.toString());
        c.reverse();
        if(c.toString().equals(b.toString())){
           return Optional.of(a);
        }
        return Optional.ofNullable(null);

    }

    private static void joined234(List<String> list, StringBuilder str1) {
        System.out.print("7.Join the second, third and forth strings of the list:");
        list.stream().forEach((n)->{
            if(n.length()>1 && n.length()<5){
                str1.append(n);
                str1.append("-");
            }
        });
        str1.delete(str1.length()-1, str1.length());
        System.out.println(str1);
    }

    private static void lowerCaseNewList(List<String> list, List<String> list1) {
        System.out.print("5. and 6. New List ");
        list.stream().forEach((n)->{
            list1.add(n.toLowerCase());

        });
        removeOddLength(list1);
    }


    private static void listToUpper(List<String> list) {
        System.out.print("3.Upper:");
        list.stream().forEach((n)->{
            System.out.println(n.toUpperCase()+" ");
        });
    }

    private static void removeOddLength(List<String> list) {
        System.out.print("2.After removing odd length:");
        list.removeIf(n-> n.length()%2==1);
        System.out.println(list);
    }

    private static void extractFirstLetter(List<String> list, StringBuilder str) {
        System.out.println("1.Initiale:");
        list.stream().forEach((n)->{
            str.append(n.charAt(0));
        });
        System.out.println(str);
    }

}
