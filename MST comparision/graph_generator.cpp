#include<stdio.h>
#include<stdlib.h>

void generateSparseGraph(int totalVertices, char* fileName)
{
	FILE* fp = fopen(fileName, "w+");

	for(int i=1; i<totalVertices; i++)
	{
		int randomWeight = (rand() % 100 ) + 1;
		
		fprintf(fp, "%d %d %d\n", i, i+1, randomWeight);
		fprintf(fp, "%d %d %d\n", i+1, i, randomWeight);
	}

	fclose(fp);
}

void generateDenseGraph(int totalVertices, char* fineName)
{
	FILE* fp = fopen(fineName, "w+");

	for(int i=1; i<=totalVertices; i++)
	{
		for(int j=1; j<=totalVertices; j++)
		{
			if (i<j)
			{
				int randomWeight = (rand() % 100 ) + 1;
					
				fprintf(fp, "%d %d %d\n", i, j, randomWeight);
				fprintf(fp, "%d %d %d\n", j, i, randomWeight);
			}
		}
	}

	fclose(fp);
}

int main()
{
	printf("starting...\n");

	generateSparseGraph(500, "data/sparse_500.txt");
	generateSparseGraph(1500, "data/sparse_1500.txt");
	generateSparseGraph(2500, "data/sparse_2500.txt");
	generateSparseGraph(3500, "data/sparse_3500.txt");
	generateSparseGraph(4500, "data/sparse_4500.txt");
	
	generateDenseGraph(500, "data/dense_500.txt");
	generateDenseGraph(1500, "data/dense_1500.txt");
	generateDenseGraph(2500, "data/dense_2500.txt");
	generateDenseGraph(3500, "data/dense_3500.txt");
	generateDenseGraph(4500, "data/dense_4500.txt");

	printf("ending...\n");

	return 0;
}

