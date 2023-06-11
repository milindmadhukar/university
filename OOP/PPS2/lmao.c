#include <stdio.h>
#include <string.h>

//Name = Param Chhabra
//Reg.no = 22BCE0744

struct BookDetails
{
    int BookNo;
    char BookName[50];
    char AuthorName[50];
    int Pages;
};

struct BookDetails library[100];
int libraryindex = 0;

void AddBooks(){
    struct BookDetails s1;
    int num,page;
    char name[50],auth[50];
    scanf("%d",&num);
    scanf("\n");
    fgets(name, sizeof(name), stdin);
    fgets(auth,sizeof(auth),stdin);
    scanf("%d",&page);


    s1.BookNo = num;
    strcpy(s1.BookName,name);
    strcpy(s1.AuthorName,auth);
    s1.Pages = page;

    library[libraryindex] = s1;
    libraryindex = libraryindex + 1;
}

void DisplayDetails(){
    int i;
    for (i = 0; i < libraryindex; i++)
    {
        printf("%d\n",library[i].BookNo);
        printf("%s",library[i].BookName);
        printf("%s",library[i].AuthorName);
        printf("%d\n",library[i].Pages);
    }
}

void MatchingAuthors(char name[50]){
    int i;
    for (i = 0; i < libraryindex; i++)
    {
        if (strcmp(library[i].AuthorName,name) == 0)
        {
            printf("%s\n",library[i].BookName);
        }
    }
}

void CountBooks(){
    printf("%d\n",libraryindex);
}


int main(){
    int choice,number,i;
    char authorname[50];
    do
    {
        printf("\n");
        scanf("%d",&choice);
        switch (choice)
        {
        case 1:
            scanf("%d",&number);
            for (i = 0; i < number; i++)
            {
                AddBooks();
            }
            break;
        
        case 2:
            DisplayDetails();
            break;
        
        case 3:
            scanf("\n");
            fgets(authorname,sizeof(authorname),stdin);
            // authorname[strcspn(authorname, "\n")] = '\0';
            MatchingAuthors(authorname);
            break;
        
        case 4:
            CountBooks();
            break;
        
        case 5:
            break;

        default:
            printf("Invalid Input");
            break;
        }
    } while (choice!=5);

    return 0;
}
