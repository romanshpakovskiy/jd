package by.it.Shpakovskiy._tasks_.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String[] strArr = Poem.text.split("\n");
        StringBuilder[] fArr = new StringBuilder[strArr.length];
        int maxLength = 0;
        for(int i = 0; i < strArr.length; i++){
            fArr[i] = new StringBuilder(strArr[i]);
        }

        for(String a: strArr){
            if(a.length() > maxLength){
                maxLength = a.length();
            }
        }

        for(StringBuilder builder: fArr){
            int count;
            while(builder.length() < maxLength){
                count = 0;
                while(count < builder.length()){
                    if(builder.charAt(count) == ' ' && builder.charAt(count + 1) != ' '){
                        builder.insert(count, " ");
                        count += 2;
                    } else ++count;
                    if(builder.length() ==  maxLength) break;
                }
            }
        }

        for(int i = 0; i < fArr.length; i++){
            fArr[i].append("\n");
        }

        for (StringBuilder stringBuilder : fArr) {
            System.out.print(stringBuilder);
        }
    }
}

