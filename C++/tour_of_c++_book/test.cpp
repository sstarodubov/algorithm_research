#include <iostream>

int *func()
{
    return new int[5]{1, 2, 3, 4, 5};
}

void double_arr(int arr[], int size)
{
    for (size_t i = 0; i < size; i++)
    {
        arr[i] = arr[i] * 2;
    }
}

int main()
{

    int arr[3] = {1, 2, 3};
    
    double_arr(arr, 3);
    
    for (auto& el : arr)
    {
        std::cout << el << std::endl;
    }

    return 0;
}