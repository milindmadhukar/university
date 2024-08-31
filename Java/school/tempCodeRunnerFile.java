m.out.print("Enter a Sentence : ");
       str = sc.nextLine();
       str = str.trim();
       for(int i = 0 ;i<str.length() ;i++)
       {
           if(str.charAt(i) == ' ')
               no_of_words++;
        }
       String word[] = new String[no_of_words];
       for(int i = 0 ;i<word.length ;i++)
       {
           word[i] = "";
       }
       for(int i = 0 ; i < str.length() ;i++)
       {
           word[j] += str.charAt(i);
           word[j] = word[j].trim();
           if(str.charAt(i) == ' ')
               j++;
        }
       for(int i = 0,j = 0 ;j < no_of_words ; i++)
       {
           temp = word[j].charAt(i) + temp;
           int len = word[j].length();
           if(i == len -1 )
           {
              word[j] = temp;
              j++;
              temp = "";
              i = -1;
           }
           if(j == no_of_words)
           break;
       }
       for(int i = 0 ; i < no_of_words ;i++)
       {
           System.out.print(word[i] + " ");
       }
