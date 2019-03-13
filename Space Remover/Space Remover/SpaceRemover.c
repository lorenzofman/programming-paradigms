#include <stdio.h>
#include <stdlib.h>
void LogInstructions() 
{
	printf("Input a string that you want to remove the spaces from it: ");
}

//http://www.gnu.org/software/libc/manual/html_mono/libc.html#Dynamic-String-Input (12.14.6)
char *ReadInput() 
{
	int bufferSize = 1, index = 0;
	char * result = (char*)malloc(bufferSize * sizeof(char)),ch;
	do
	{
		ch = (char)getc(stdin);
		if (index == bufferSize) 
		{
			bufferSize *= 2;
			result = (char*)realloc(result, bufferSize * sizeof(char));
		}
		result[index++] = ch;
	} 
	while (ch && ch != '\n');
	result[index++] = '\0';
	return result;
}

int StrlenWithoutSpecialChar(char* string, char specialChar) 
{
	int requiredBufferSpace = 0;
	while (*(string++)) {
		if (*string != specialChar) {
			requiredBufferSpace++;
		}
	}
	return requiredBufferSpace + 1;
}

void CopyStringExcludingSpecialChar(char *original, char *resultBuffer, char specialChar) 
{
	char *aux = resultBuffer;
	do 
	{
		if (*original != specialChar) {
			*(resultBuffer++) = *original;
		}
	}
	while (*(original++));
	*resultBuffer = '\0';
}

char *CreateStringWithoutSpecialChar(char* sentence, char specialChar) 
{
	int requiredBufferSpace = StrlenWithoutSpecialChar(sentence, specialChar);
	char *result = (char*)malloc(requiredBufferSpace * sizeof(char));
	CopyStringExcludingSpecialChar(sentence, result, specialChar);
	return result;
}

int main() 
{
	LogInstructions();
	char *sentence = ReadInput();
	char * result = CreateStringWithoutSpecialChar(sentence, ' ');
	printf(result);
	system("pause");
}