package Pattern1.HomeWork;

import java.util.List;

public class QueryHolder {

    List<String> select;
    String from;
    List<String> where;
    String orderBy;
    String groupBy;
    List<String> having;

    List<String> joinTables;

    List<String> joinON;

    private QueryHolder(QueryBuilder qb) {
        this.select = qb.select;
        this.from = qb.from;
        this.where = qb.where;
        this.orderBy = qb.orderBy;
        this.groupBy = qb.orderBy;
        this.having = qb.having;
        this.joinTables = qb.joinTables;
        this.joinON = qb.joinON;
    }

    public static QueryBuilder getBuilder(){
        return new QueryBuilder();
    }

    public String buildNormalQuery() {

        String query = "";

        if(this.select != null && this.select.size() > 0) {
            query += "SELECT ";
            int size = this.select.size();
            int i = 0;
            while(i < size) {
                query += this.select.get(i);
                if(i != size - 1) query += ", ";
                i++;
            }
        }

        else{
            return "please provide column names";
        }

        if(this.from != null) {
            query += " FROM " + this.from;
        }

        else {
            return "Please provide table name";
        }

        if(this.where != null && this.where.size() > 0) {
            query += " WHERE ";
            int i = 0;
            int size = this.where.size();
            while(i < size) {
                query += this.where.get(i);
                if(i != size - 1) query += ", ";
                i++;
            }
        }

        if(this.orderBy != null) {
            query += " ORDERBY ";
            query += this.orderBy;
        }

        return query;
    }

    public String joinQuery() {
        String query = "";

        if(this.select != null && this.select.size() > 0) {
            query += "SELECT ";
            int size = this.select.size();
            int i = 0;
            while(i < size) {
                query += this.select.get(i);
                if(i != size - 1) query += ", ";
                i++;
            }
        }

        else{
            return "Please provide column names";
        }

        if(this.joinTables != null && this.joinTables.size() > 0) {
            query += " FROM ";
            query += this.joinTables.get(0) + " JOIN " + this.joinTables.get(1) + " ON ";
            if (this.joinON != null && this.joinON.size() == 2) {
                query += this.joinON.get(0) + " = " + this.joinON.get(1);
            } else {
                return "Please provide valid joining ids";
            }
            return query;
        }
        return null;
    }

    public static class QueryBuilder {

        List<String> select;
        String from;
        List<String> where;
        String orderBy;
        String groupBy;
        List<String> having;

        List<String> joinTables;

        List<String> joinON;

        public List<String> getJoinTables() {
            return joinTables;
        }

        public QueryBuilder setJoinTables(List<String> joinTables) {
            this.joinTables = joinTables;
            return this;
        }

        public List<String> getJoinON() {
            return joinON;
        }

        public QueryBuilder setJoinON(List<String> joinON) {
            this.joinON = joinON;
            return this;
        }



        public List<String> getSelect() {
            return select;
        }

        public QueryBuilder setSelect(List<String> select) {
            this.select = select;
            return this;
        }

        public String getFrom() {
            return from;
        }

        public QueryBuilder setFrom(String from) {
            this.from = from;
            return this;
        }

        public List<String> getWhere() {
            return where;
        }

        public QueryBuilder setWhere(List<String> where) {
            this.where = where;
            return this;
        }

        public String getOrderBy() {
            return orderBy;
        }

        public QueryBuilder setOrderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        public String getGroupBy() {
            return groupBy;
        }

        public QueryBuilder setGroupBy(String groupBy) {
            this.groupBy = groupBy;
            return this;
        }

        public List<String> getHaving() {
            return having;
        }

        public QueryBuilder setHaving(List<String> having) {
            this.having = having;
            return this;
        }

        public QueryHolder build() {
            return new QueryHolder(this);
        }
    }
}
