package Pattern1.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String query1 = QueryHolder.getBuilder().setSelect(Arrays.asList("name" , "rollNo"))
                                               .setFrom("user")
                                               .setWhere(Arrays.asList("rollNo > 20"))
                                               .setOrderBy("name").build().buildNormalQuery();

        String query2 = QueryHolder.getBuilder().setSelect(Arrays.asList("name" , "rollNo" , "address"))
                                                .setJoinTables(Arrays.asList("users" , "students"))
                                                .setJoinON(Arrays.asList()).build().joinQuery();
        System.out.println(query1);
        System.out.println(query2);
    }
}
