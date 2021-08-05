# STL

> 작성자 : [박재용](https://github.com/ggjae)

- C++의 기본! STL이 무엇인지 이해하기
- STL을 직접 사용해보기

<details>
<summary>Table of Contents</summary>

- [What is STL](#STL)
- [What is Container](#STL-컨테이너)
- [What is Iterator](#STL-반복자)
- [What is Algorithm](#STL-알고리즘)
- [What is Functor](#STL-함수자)

</details>

---

## STL

STL은 Standard Template Library로 C++를 위한 표준 라이브러리로서 컨테이너, 반복자, 알고리즘 그리고 함수자라고 불리는 네가지의 구성요소를 제공한다. (C++ : Black Book)  
C++에서 vector, queue 등 다양한 라이브러리들을 #include 하여 사용한 적이 있는가? 이것들이 STL의 일부이다.

### 우리가 왜 STL을 배워야 하는가?

초창기 STL은 열악한 성능과 버그에 의해서 개발자들의 호응을 끌어낼 수 없었지만 최근에는 STL 없이 C++을 논할 수 없을만큼 중요해졌다. STL을 사용함으로서 효율적인 프로그래밍이 가능해졌다.

## STL 컨테이너

일반적으로 컨테이너는 다른 객체들을 보관하는 하나의 커다란 보관소라고 볼 수 있다. STL 컨테이너의 경우 클래스 템플릿의 형태로 구현되어 있기 때문에 임의의 타입 원소들을 위한 컨테이너를 만들 수 있다. 표준 라이브러리에서는 여러가지 형태의 컨테이너를 제공한다.  
시퀀스 컨테이너 - Sequence Container
> ex) `vector, deque, array, priority_queue, list`


연관 컨테이너 - Associative Container
> ex) `set, map, multiset, multimap, unordered_set, unordered_map`

## STL 반복자
> iterator

포인터와 비슷한 개념으로 컨테이너의 원소를 가리키고, 가리키는 원소에 접근하여 순회가 가능한 반복자. 구체적으로 설명하자면 컨테이너에서 보유하는 내부 데이터를 순회할 수 있는 객체로 컨테이너의 특정 위치를 나타낸다.
C++에서는 아직 자료를 포인터 단위로 관리하기에 해당 자료의 위치에서 데이터에 접근하고 사용하기 위해서 그 위치에 저장된 자료구조를 읽는데 **반복자**가 필요하다.
> ex1) `begin()` - 컨테이너의 첫번째 위치를 가리키는 반복자를 반환

> ex2) `end()` - 컨테이너의 마지막 위치를 가리키는 반복자를 반환

1. *연산자 : 지금 현재 위치의 원소를 반환
2. ++연산자 : 컨테이너의 다음 원소를 가리키는 위치로 반복자가 이동
3. --연산자 : 컨테이너의 이전 원소를 가리키는 위치로 반복자가 이동
4. = 연산자 : 반복자가 참조하는 원소의 위치를 다른 반복자에 할당
5. ==, != 연산자 : 비교 연산자

## STL 알고리즘

정렬, 삭제, 검색, 연산 등을 해결하는 일반화된 방법을 제공하는 함수 Template

1. 계수 알고리즘
count(), count_if()  
주어진 값과 일치하거나, 조건에 맞는 요소들의 개수를 count

2. 탐색 알고리즘
search(), search_n(), find(), find_if(), find_end(), binary_search()  
주어진 값과 일치하거나, 조건에 맞는 요소를 반환

3. 비교 알고리즘
equal(), mismatch(), lexicographical_compare()  
두개의 요소가 같은지 비교

4. 초기화 알고리즘
fill(), generate()  
지정된 범위의 요소를 지정한 값으로 할당 및 함수의 반환 값 할당

5. 변경 알고리즘
for_each(), transform()  
지정된 범위의 모든 요소에 대한 연산과 함수 적용

6. 복사 알고리즘
copy()  
하나의 구간을 다른 구간으로 복사

7. 삭제 알고리즘
remove(), unique()  
지정된 값을 가지는 요소를 삭제하거나, 중복된 요소를 삭제

8. 대치 알고리즘
replace()  
지정된 구간에서 요소가 지정된 값과 일치하면 대치값으로 바꿈

9. 정렬 알고리즘
sort()  
지정된 정렬 기준에 따라서 구간의 요소들을 정렬

10. 분할 알고리즘
partition()  
지정된 구간의 요소들을 조건에 따라서 두개의 집합으로 나눔

**이러한 것들이 STL에 기본으로 내장된 알고리즘이라니 정말 C++ STL이 놀랍지 않은가?**

## STL 함수자

STL 함수자란 함수 객체와 같은 말로, operator() 연산자를 오버로딩한 클래스 객체이다.
우리가 C++을 사용할 때 
`sort(v.begin(), v.end(), less<int>());` 의 세번째 인자 less, greater를 사용했던 기억이 있는가?   
이것이 바로 함수처럼 동작하는 객체인 함수자이다.

우리와 같은 C++ 개발자는 함수자를 이용한 함수를 많이 사용하지 않는다. 함수 포인터를 인자로 사용했을 경우의 단점은 반환값과 인자가 동일한 함수에 대해서만 동작하기 때문에 범용성이 떨어지기 때문이다.

### 비교 함수자
비교 연산 기능을 수행하는 함수자  
less<Type>(), greater<Type>(), equal_to<Type>(), greater_equal<Type>() 등이 존재한다.

### 산술 함수자
산술 연산 기능을 수행하는 함수자  
plus<Type>(), minus<Type>(), multiplies<Type>(), divides<Type>() 등이 존재한다.

### 논리 함수자
논리 연산 기능을 수행하는 함수자  
logical_and<Type>(), logical_or<Type>(), logical_not<Type>() 등이 존재한다.

### plus 함수자를 사용하는 예시
```cpp
#include <iostream>
#include <functional>
#include <algorithm>
#include <vector>
using namespace std;

void main( )
{
    vector<int> v1;
    vector<int> v2;


    v1.push_back(10); 

    v1.push_back(20);
    v1.push_back(30);

    v2.push_back(1);
    v2.push_back(2);
    v2.push_back(3);

    for(int i = 0 ; i < v1.size() ; i++)
        cout << v1[i] << " "; // 10, 20, 30
    cout << endl;

    for(int i = 0 ; i < v2.size() ; i++)
        cout << v2[i] << " "; // 1, 2, 3
    cout << endl;

    transform(v1.begin(), v1.end(), v2.begin(), v1.begin(), plus<int>());

    for(int i = 0 ; i < v1.size() ; i++)
        cout << v1[i] << " "; // 11, 22, 33
    cout << endl;
}
```

## 함수 어댑터 (function adaptor)

어댑터란 컨테이너의 인터페이스 또는 함수자의 기능을 변경하는 컴포넌트를 말한다.
기존의 컨테이너를 이용해서 스택을 꾸미고 싶을 때에는 스택 어댑터를, 함수자의 의미를 변경할 때는 바인더나 부정자를 사용한다.

* 바인더(binder)  
두개의 인자를 필요로 하는 이항 함수 객체의 인자 하나를 고정시켜 인자를 하나만 요구하는 단항 함수 객체로 변환

* 부정자(negator)  
함수 인자로 사용되는 조건자의 의미를 반대로 변환

* 함수 포인터 어댑터(adaptors for pointers to functions)  
단항이나 이항 함수 포인터를 라이브러리가 제공하는 함수 어댑터와 사용할 수 있도록 도움

* 멤버 함수 포인터 어댑터(adaptors for pointers to member functions)  
단항이나 이항 멤버 함수 포인터를 라이브러리가 제공하는 함수 어댑터와 사용할 수 있도록 도움

### 바인더 어댑터

* bind1st  
함수자에 전달되는 두개의 인자 중 첫번째 인자를 고정값으로 사용할 수 있도록 도와주는 바인더

* bind2nd  
함수자에 전달되는 두개의 인자 중 두번째 인자를 고정값으로 사용할 수 있도록 도와주는 바인더

  
less 함수자에 bind1st 어댑터를 씌운 예시
```cpp
#include <iostream>
#include <functional>
using namespace std;
 
int main(void){
    // 첫 인자를 10으로 고정
    binder1st<less<int>> binder = bind1st (less<int>(), 10);
 
    cout << binder(5) << ':' << less<int>()(10, 5) << endl;
    cout << binder(10) << ':' << less<int>()(10, 10) << endl;
    cout << binder(20) << ':' << less<int>()(10, 20) << endl;
 
    cout << "== ==" << endl;
 
    // 임시 객체 사용
    cout << bind1st(less<int>(), 10) (5) << ':' << less<int>()(10, 5) << endl;
    cout << bind1st(less<int>(), 10) (10) << ':' << less<int>()(10, 10) << endl;
    cout << bind1st(less<int>(), 10) (20) << ':' << less<int>()(10, 20) << endl;
 
}
```
실행 결과
```cpp
0:0
0:0
1:1
== == 
0:0
0:0
1:1
```

### 부정자 어댑터
    
[ref](http://www.cplusplus.com/reference/functional/not1/)
    
* not1  
인자로 전달된 단항 조건자의 의미를 반대로 변환

> 5의 배수인지 확인하는 isMulti5 함수를 만들었다고 가정했을 때 not1(isMulti5()); 을 사용하면 5의 배수가 아닌것만 확인하게 된다.
    
* not2  
인자로 전달된 이항 조건자의 의미를 반대로 변환

> ex) `sort(v.begin(), v.end(), compare());`을 오름차순이라고 가정했을 때 `sort(v.begin(), v.end(), not2(compare())); 은 내림차순이 된다.
    
### 함수 포인터 어댑터
함수 포인터는 객체가 아니므로 어댑터를 적용할 수 없는데 아래의 함수 포인터 어댑터를 사용함으로써 함수 포인터를 객체로 포장하게 되고 이 후 바인더, 부정자 등의 어댑터를 적용할 수 있다.
    
* ptr_fun  
단항 함수를 함수 어댑터처럼 사용할 수 있도록 지원
    
```cpp
bool IsMultiFunc(int a,int b)
{
     return (a % b == 0);
}
void main(){
     int ari[]={1,2,3,4,5,6,7,8,9,10};
     vector<int> vi(&ari[0],&ari[10]);
     vector<int>::iterator it;
     for (it=vi.begin();;it++) {
          it=find_if(it, vi.end(), bind2nd(ptr_fun(IsMultiFunc),3));
          if (it==vi.end()) break;
          cout << *it << "이(가) 있다" << endl;
     }
}
```
