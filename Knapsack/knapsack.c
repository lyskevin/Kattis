#include <stdio.h>
#include <stdbool.h>

/**
 * @author lyskevin
 */

int c, n;
int values[2000], weights[2000], memoTable[2000][2001];
bool items[2000];

int findItems(int index, int remainingCapacity);
int max(int a, int b);

int main(void)
{
    while (scanf("%d", &c) == 1 && scanf("%d", &n) == 1)
    {
        for (int i = 0; i < n; i++)
        {
            scanf("%d", &values[i]);
            scanf("%d", &weights[i]);
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < c + 1; j++)
            {
                memoTable[i][j] = -1;
            }
        }

        findItems(0, c);

        for (int i = 0; i < n; i++)
        {
            items[i] = false;
        }
        
        int weight = c;
        int count = 0;

        // Reconstruct items which are taken
        for (int i = 0; i < n; i++)
        {
            if (i == n - 1)
            {
                if (memoTable[i][weight] > 0) 
                {
                    items[i] = true;
                    count++;
                }
            }
            else if (memoTable[i][weight] > memoTable[i + 1][weight])
            {
                items[i] = true;
                count++;
                weight -= weights[i];
            }
        }

        // Print items
        printf("%d\n", count);
        bool isFirst = true;
        int index = 0;
        while (index < n)
        {
            if (items[index])
            {
                if (!isFirst)
                {
                    printf("%c", ' ');
                }
                printf("%d", index);
                isFirst = false;
            }
            index++;
        }
        printf("\n");
    }
}

int findItems(int index, int remainingCapacity)
{
    // End index passed or no remaining capacity left
    if (index == n || remainingCapacity == 0)
    {
        return 0;
    }

    // Weight value already memoized
    else if (memoTable[index][remainingCapacity] != -1)
    {
        return memoTable[index][remainingCapacity];
    }

    // Cannot take the current item (too heavy)
    else if (weights[index] > remainingCapacity)
    {
        return memoTable[index][remainingCapacity] = findItems(index + 1, remainingCapacity);
    }

    // Choose the max value between taking the current item and not taking it
    else
    {
        return memoTable[index][remainingCapacity] = max(findItems(index + 1, remainingCapacity),
                values[index] + findItems(index + 1, remainingCapacity - weights[index]));
    }
}

int max(int a, int b)
{
    if (a >= b)
    {
        return a;
    }
    return b;
}

