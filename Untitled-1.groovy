#include <iostream>  
#include <vector>  
#include <unordered_set>  
#include <algorithm>  
  
class IntArray {  
private:  
    std::vector<int> data;  
  
    // 辅助函数：去重并保持原始顺序  
    void internalRemoveDuplicates() {  
        std::unordered_set<int> seen;  
        std::vector<int> temp;  
        for (int num : data) {  
            if (seen.find(num) == seen.end()) {  
                seen.insert(num);  
                temp.push_back(num);  
            }  
        }  
        data.swap(temp); // 用去重后的临时向量替换原始向量  
    }  
  
public:  
    // 追加元素  
    void append(int value) {  
        data.push_back(value);  
    }  
  
    // 插入元素到指定位置  
    void insert(int index, int value) {  
        if (index >= 0 && index <= data.size()) {  
            data.insert(data.begin() + index, value);  
        } else {  
            std::cerr << "Invalid index for insertion." << std::endl;  
        }  
    }  
  
    // 查找最大值  
    int findMax() const {  
        if (data.empty()) throw std::runtime_error("Array is empty");  
        return *std::max_element(data.begin(), data.end());  
    }  
  
    // 查找最小值  
    int findMin() const {  
        if (data.empty()) throw std::runtime_error("Array is empty");  
        return *std::min_element(data.begin(), data.end());  
    }  
  
    // 计数：计算某个值的出现次数  
    int count(int value) const {  
        return std::count(data.begin(), data.end(), value);  
    }  
  
    // 查找：返回第一个等于给定值的元素的索引，如果不存在则返回-1  
    int findValue(int value) const {  
        auto it = std::find(data.begin(), data.end(), value);  
        if (it != data.end()) {  
            return std::distance(data.begin(), it);  
        }  
        return -1;  
    }  
  
    // 去重  
    void removeDuplicates() {  
        internalRemoveDuplicates();  
    }  
  
    // 移除：移除指定索引处的元素  
    void removeAt(int index) {  
        if (index >= 0 && index < data.size()) {  
            data.erase(data.begin() + index);  
        } else {  
            std::cerr << "Invalid index for removal." << std::endl;  
        }  
    }  
  
    // 打印数组内容  
    void print() const {  
        for (int num : data) {  
            std::cout << num << " ";  
        }  
        std::cout << std::endl;  
    }  
};  
  
int main() {  
    IntArray arr;  
    arr.append(5);  
    arr.append(3);  
    arr.append(9);  
    arr.append(3);  
    arr.append(7);  
    arr.append(5);  
  
    arr.print(); // 打印原始数组  
  
    std::cout << "Max: " << arr.findMax() << std::endl;  
    std::cout << "Min: " << arr.findMin() << std::endl;  
    std::cout << "Count of 3: " << arr.count(3) << std::endl;  
    std::cout << "Index of 9: " << arr.findValue(9) << std::endl;  
  
    arr.removeDuplicates();  
    arr.print(); // 打印去重后的数组  
  
    arr.removeAt(1); // 假设我们要移除去重后索引为1的元素（即第二个元素）  
    arr.print(); // 打印移除元素后的数组  
  
    return 0;  
}