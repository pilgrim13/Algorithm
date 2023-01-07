#include<iostream>
#include<cstdio>
#include<algorithm>
#include<cmath>
using namespace std;

int M, N;

void getPrime(int num) {

	int *arr;
	arr = (int *)malloc(sizeof(int)*(num + 1));

	for (int i = 2; i <= num; i++) arr[i] = i;

	for (int i = 2; i <= num; i++) {
		if (arr[i] == 0) continue;
		for (int j = i + i; j <= num; j += i) {
			arr[j] = 0;
		}
	}

	for (int i = M; i <= N; i++) {
		if (arr[i] != 0) printf("%d\n", arr[i]);
	}
	free(arr);
}


int main(void) {

	scanf("%d %d", &M, &N);
	getPrime(N);

	return 0;
}