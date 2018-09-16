#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>


// the number of alphabets or ' in each trie
#define ALPHA 27

// here's our trie
typedef struct trie
{
    // we need a pointer to all of our other letters and the apostrophe
    struct trie *letters[ALPHA];

    // and we need to see if the word ends here
    bool lastLetter;
}
trie;

// declaring functions
int getKey(char c);
trie* createNode(void);
bool addWord(trie *root, char *str);
bool findWord(trie *root, char *str);
void destroy(trie *root);

int main(void)
{
    // dictionary is our test word
    char *str = "dictionary";

    // create the trie root
    trie *root = createNode();

    // add dictionary to the trie
    addWord(root, str);

    // check for the word
    int x = findWord(root, "dictionary");
    printf("\n");
    int y = findWord(root, "avacado");
    printf("\n");

    printf("%i, %i", x, y);
    destroy(root);

}

int getKey(char c)
{
    int key = 0;

    // check if key is a letter and convert it to a = 0 index
    if (isalpha(c))
    {
        // the letter is lowercase
        if (islower(c))
        {
            key = c - 'a';
        }
        // the letter is uppercase
        else
        {
            key = c - 'A';
        }
    }
    // it's an apostrophe
    else
    {
        key = ALPHA - 1;
    }

    // return key
    return key;
}

// if createNode returns NULL; abort
trie* createNode(void)
{
    // make room for the root
    trie *node = malloc(sizeof(trie));
    if (!node)
    {
        return NULL;
    }

    // set all pointers to null
    for (int i = 0; i < ALPHA; i++)
    {
        node->letters[i] = NULL;
    }

    // Never the last letter at this point
    node->lastLetter = false;

    // return the node
    return node;
}

// if addWord returns false, abort
bool addWord(trie *root, char *str)
{
    // Create a pointer to traverse
    trie *ptr = root;

    // Iterate through the string and open up the keys in order
    for (int i = 0; str[i] != '\0'; i++)
    {
        // Convert the character into it's index value
        int key = getKey(str[i]);

        // If the current letter-gate points to NULL, create a new node
        if (!ptr->letters[key])
        {
            // if malloc fails, return false;
            trie *newNode = createNode();
            if (!newNode)
            {
                return false;
            }

            // Point the letter-gate at the the new node
            ptr->letters[key] = newNode;
        }

        // Move the pointer forward in the chain
        ptr = ptr->letters[key];
    }

    // At the end of the chain, mark the boolean as true
    ptr->lastLetter = true;
    return ptr->lastLetter;
}

bool findWord(trie *root, char *str)
{
    // Create a pointer to traverse
    trie *ptr = root;

    // Iterate through the string
    for (int i = 0; str[i] != '\0'; i++)
    {
        // Convert each character into it's index key
        int key = getKey(str[i]);

        // If any of the gates are closed, return false
        if (!ptr->letters[key])
        {
            return false;
        }

        // Move the pointer through the trie
        ptr = ptr->letters[key];
    }

    // If we stopped at an actual word ending, return true
    if (ptr->lastLetter)
    {
        return true;
    }

    // In all other cases, return false
    return false;
}

void destroy(trie *root)
{
    trie *ptr = root;

    for (int i = 0; i < ALPHA; i++)
    {
        if (ptr->letters[i])
        {
            destroy(ptr->letters[i]);
        }
    }

    free(ptr);
}