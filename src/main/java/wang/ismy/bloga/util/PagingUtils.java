package wang.ismy.bloga.util;

import java.util.ArrayList;

public class PagingUtils {

    public static String calcPages(int pageCounts, int pages,String...args) {
        if(pageCounts==0){
            return "当前结果不足以翻页" ;
        }
        StringBuilder sb = new StringBuilder();
        if(pages==1){
            sb.append("<span class=\"disabled\"> < </span>");
        }else{
            sb.append(pageUrl(pages-1,"<",args));
        }

        if(pageCounts>=8){
            if(pages>1 && pages<pageCounts){
                sb.append(pageUrl(1,String.valueOf(1),args));
                ArrayList<Integer> n=getPageN(pageCounts,pages);
                if(n.get(0)>2){
                    sb.append("...");
                }
                for(int i:n){
                    if(i==pages){
                        sb.append(" <span class=\"current\">"+i+"</span>");
                    }else{
                        sb.append(pageUrl(i,String.valueOf(i),args));
                    }
                }
                if(n.get(n.size()-1)<pageCounts-1){
                    sb.append("...");
                }
                sb.append(pageUrl(pageCounts,String.valueOf(pageCounts),args));
            }else if(pages==1){
                for(int i=1;i<=6;i++){
                    if(i==pages){
                        sb.append(" <span class=\"current\">"+i+"</span>");
                    }else{
                        sb.append(pageUrl(i,String.valueOf(i),args));
                    }
                }
                sb.append("...");
                sb.append(pageUrl(pageCounts,String.valueOf(pageCounts),args));
            }else if(pages==pageCounts){
                sb.append(" <a href=\"/?page="+1+"\">"+1+"</a>");
                sb.append("...");
                for(int i=pageCounts-5;i<=pageCounts;i++){
                    if(i==pages){
                        sb.append(" <span class=\"current\">"+i+"</span>");
                    }else{
                        sb.append(pageUrl(i,String.valueOf(i),args));
                    }
                }
            }

        }else{
            for(int i=1;i<=pageCounts;i++){
                if(i==pages){
                    sb.append(" <span class=\"current\">"+i+"</span>");
                }else{
                    sb.append(pageUrl(i,String.valueOf(i),args));
                }
            }
        }


        if(pages==pageCounts){
            sb.append("<span class=\"disabled\"> > </span>");
        }else{
            sb.append(pageUrl(pages+1,">",args));
        }
        System.err.println(sb);
        return sb.toString();
    }

    private static ArrayList<Integer> getPageN(int pageCounts,int pages){
        ArrayList<Integer> ret=new ArrayList<>();
        for(int i=pages-2;i<=pages+2;i++){
            ret.add(i);
        }
        if(ret.get(0)<2){
            int tmp=ret.get(0);
            for(int i=0;i<ret.size();i++){
                ret.set(i,ret.get(i)+2-tmp);
            }
        }
        if(ret.get(ret.size()-1)>=pageCounts-1){
            int tmp=ret.get(ret.size()-1)-pageCounts+1;
            for(int i=0;i<ret.size();i++){
                ret.set(i,ret.get(i)-tmp);
            }
        }
        return ret;
    }

    private static String pageUrl(int pages,String a,String ...args){

        if(args.length==0){
            return "<a href=\"./"+(pages)+"\">"+a+"</a>";
        }else{
            return "<a href=\"/"+args[0]+"?page="+(pages)+"&"+args[1]+"\">"+a+"</a>";
        }


    }
}
