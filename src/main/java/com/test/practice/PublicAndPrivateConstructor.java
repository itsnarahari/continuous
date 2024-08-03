package com.test.practice;

public class PublicAndPrivateConstructor {

    int id;

    public PublicAndPrivateConstructor() {
        System.out.println("public cons");
    }
//    private PublicAndPrivateConstructor(int id) {
//        this.id=id;
//    }

    public static String removeDups(String str){
        int i=0,j=1;
        int n=str.length()-1;
        StringBuilder stringBuilder = new StringBuilder();
        while (j<n && j>=i){
            if(str.charAt(i)==str.charAt(j)){
                j++;
            }else{
                stringBuilder.append(str.charAt(i));
                i=j;
            }
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeDups("aabbbcddddeaabb"));
    }
}
