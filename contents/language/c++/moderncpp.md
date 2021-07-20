# Modern C++

> 작성자 : [박재용](https://github.com/ggjae)

본 자료는 작성자인 '박재용'의 개인 Repository의 글과 Effective Modern C++ 책을 재구성하여 작성되었습니다.  

<details>
<summary>Table of Contents</summary>

- [What is Modern C++?](#Modern-C++이란?)
- [Auto Type](#Auto)
- [Smart Pointer](#Smart-Pointer)
- [람다 표현식](#lambda)
- [이동 시맨틱](#Move-Semantics)
- [다양한 라이브러리](#다양한-Library)

</details>

---

## Modern C++이란?

C++98(C++03) 버전 이후 최신 유행에 맞게 새로운 C++ 표준 문서가 업데이트되었고 구 버전의 C++98 기능보다 성능을 향상시킬뿐만 아니라 가독성, 코드의 간결함도 장점으로 떠오르는 새로운 C++ 기능 집합 표준화이다.

## Auto

Auto를 사용하여 변수를 선언하게 되면 특정 자료형을 지정하지 않을 수 있다. auto는 코드가 짧아지고 가독성에서 큰 장점을 가지고 있다.
중요한 점 : **전역변수나 함수의 매개변수로는 사용하지 못함**
```cpp
auto a = 100;
auto b = 100l;
auto c; // ERROR

vector<int> v;
auto be = v.begin(); // 이처럼 iterator형을 대신할 수 있다
```


## Iterator와 Auto를 결합하기

반복문에서 STL의 iterator를 유용하게 사용할 수 있다. auto 키워드와 함께 사용한다면 반복문이 얼마나 간결해지는지 살펴보자.

```cpp
for(vector<int>::iterator i = v.begin(); i != v.end(); ++i){
    // sth;
}

for(auto i = v.begin(); i != v.end(); ++i){
    // sth;
}

for(auto& i : v){
    // sth;
}
```

위의 세 for문의 동작은 같고, 코드의 길이가 확연하게 줄어드는 것을 확인할 수 있었다. 마지막 반복문의 v는 배열이나 vector가 될 수 있고 **참조변수**로 사용함으로서 복사가 발생하지 않아 메모리의 측면에서 성능이 좋다고 할 수 있다.

## 후행 반환 형식

후행 반환 형식이란 함수의 반환 형식을 기존의 리턴타입의 위치가 아니라 매개변수 목록 다음에 '->'을 사용하며 반환값을 auto로 지정한 경우에는 C++11에서는 후행 반환 형식이 필수였지만, C++14부터는 반환 타입을 추론해 준다. 하지만 개발자가 의도한 바와 다르게 반환 형식이 결정될 수 있는 문제를 신경써야 한다.

```cpp
auto function(int a, int b) -> decltype(a+b){
    return a+b;
}
```

## Smart Pointer

일반 포인터처럼 생겼지만 스마트 포인터란 무엇일까?
일반 포인터보다 똑똑하다는 것은 프로그램에서 가장 빈번히 발생하는 버그에 관련되어 있다. 버그를 줄일 수 있다는 점에서 **Smart**한 것이다. 기존 C++에서는 동적으로 할당받은 메모리를 반드시 delete를 이용하여 메모리 해제가 필수임에 따라 Modern C++에서는 Memory Leak, Segmentation fault로부터 안전성을 보장하기 위하여 Modern C++에서는 스마트 포인터를 제공한다.

가장 보편적으로 사용되는 예시로는 auto_ptr이 스마트 포인터의 예시로 가장 많이 사용되었지만 소멸동작 방식에서 객체에 대한 delete를 수행하기보다는 객체의 해제만 수행하는 치명적인 단점을 가지고 있어 C++17부터 제거 되었다. 이 문제점에 의해 unique_ptr와 shared_ptr을 주로 사용하게 되었다.

```cpp
// 기존 C/C++ pointer
Widget *getWidget();

void work()
{
    Widget *wptr = getWidget();
    // 여기서 Exception 발생 혹은 Return하게 될 경우, *wptr 메모리 해제는 어쩌죠?
    delete wptr; // 직접 명시적으로 메모리를 해제해야 함.

}
// 모던 C++의 unique_ptr(스마트 포인터의 일종)
unique_ptr<Widget> getWidget();
void work()
{
    unique_ptr<Widget> upw = getWidget();
    // Exception이 발생하거나 중간에 Return 하더라도 별도로 신경 쓸 필요가 없습니다!
}   // 메모리도 알아서 자동으로 해제됩니다.
```
코드 ref) https://www.hanbit.co.kr/media/channel/view.html?cms_code=CMS8140000918

## lambda

람다표현식(lambda expression)은 이름 없는 함수로도 불리는데 python, C#, js등에서 이미 편리하게 사용되었던 기능들이다. 제일 큰 장점으로는 함수의 인라인화가 가능하다는 것에 있다.

람다표현식이란 어떤것인지 코드를 보고 이해해보자. (in Effective Modern C++ Book)

```cpp
std::find_if(container.begin(), container.end(),
            [](int val) { return 0 < val && val < 10; });
``` 


### 문법

```cpp
[captures](parameters) -> return type { body }

/*
* captures: comma(,)로 구분된 캡처들이 들어갑니다. 캡쳐 부가 설명을 아래에 작성했습니다.
* [] : 아무 외부변수도 사용하지 않음
* [=] : 모든 외부변수의 값을 전달받아서 캡쳐한다. value 만 사용하고, 외부변수의 값을 바꾸지는 못함.
* [&] : 모든 외부변수를 참조로 전달받아서 캡쳐한다. value도 사용하고, 외부변수의 값도 바꿀 수 있다. 
* [A] : 외부변수 A를 값으로 전달받아서 캡쳐한다. 단 A의 value는 사용할 수 있으나 값을 바꿀 수 없다.
* [&A] : 외부변수 A를 참조로 전달받아서 캡쳐한다. value도 사용하고, 값도 바꿀 수 있다.
* parameters: 함수의 인자들이 들어갑니다.
* return type: 함수의 반환형입니다.
* body: 함수의 몸통입니다.
*/
```

### 다양한 사용 예시
기본 사용법
```cpp
int main(){
    auto a = 5;
    [&](){a = 3;cout<<a<<endl;}();
}
```

함수 포인터로 사용하기 1
```cpp
int main(){
    auto a = 5;
    auto func = [&](){a = 3;cout<<a<<endl;};
    func();
}
```
함수 포인터로 사용하기 2
```cpp
int main(){
    auto a = 5;
    function<void()> func = [&](){a = 3;cout<<a<<endl;};
    func();
}
```
람다를 반환하는 함수
```cpp
auto a = 5;
auto getLambda() {//C++14
    return [&]() {a = 3;cout<<a<<endl;};
}
int main(){
    auto func = getLambda();
    func();
}
```
재귀함수로 쓰이는 람다
```cpp
int main(){
    function<int (int)> func = [&func] (int num) -> int
    {
        if(num <= 1)return 1;
        else return num*func(num-1);
    }; 
    auto a = func(5);
    cout<<a<<endl;
}
```

## Move Semantics

이동 시맨틱이란 C++11에서 추가된 문법으로 Move Semantics이 등장한 이유이기도 하기 때문에 기존 C++ 복사가 가진 C++ Copy Semantics의 문제점에 대해서 먼저 생각해보자. C++에서는 어느 한 객체의 상태를 다른 객체로 복사하는 일이 가능하다. 하지만 이 구동 방식은 
1. 사진 복사를 위하여 PC에 폴더를 하나 만들고
2. SD 카드에서 사진들을 선택해 컴퓨터로 복사하고
3. 복사가 끝나면 원본 사진을 삭제하고
4. 삭제가 끝나면 이 복사한 사진들을 가지고 작업을 시작하는 방식
위처럼 정말 효율이 떨어졌다. 이러한 Copy 비효율을 없애기 위하여 Modern C++에서는 Move Semantics이라는 개념을 적용시켰다. 메모리 소유권 이전으로 비용이 발생하지 않는다는 큰 장점을 가지고 있다.

Move Semantic의 사용 예시를 알아보기 전에 L-value와 R-value에 대해 알아보자.


### L-value

L value는 접근할 수 있는 주소를 가진 변수를 말한다.
- 이름이 있는 변수, 함수 ex) int a; foo();
- 선행 증감 연산자 ex) ++a;, --b;
- L-value 배열의 인덱스 접근 ex) a[n];

### Pure rvalue

prvalue라고 하는데 접근은 할 수 있지만 주소를 가지지 못한 표현식을 말한다.
- 리터럴 값 (string은 제외)
- 후행 증감 연산자 ex) a++, b--
- 값 리턴 함수 호출 ex) return str1+str2;

### X-value

xvalue는 접근할 수 있는 주소를 가지지만 이동 연산을 할 수 있는것을 말한다.
- rvalue 참조를 리턴하는 함수 ex) std::move(x)
- rvalue 배열의 인덱스 접근 ex) r[n]

### R-value
Pure rvalue와 X-value를 묶어서 R-value라고 말한다.

```cpp
int tmain(int argc, _TCHAR* argv[])
{
    int num1 = 5, num2 = 3;
    
    num1 = 10;                  // num1은 lvalue, 10은 int형 prvalue
    num1 = num2;                // num1은 lvalue, num2은 lvalue
    int num3 = num1 + num2;     // num3은 lvalue, num1 + num2은 prvalue
    
    std::move(num3);            // rvalue 참조를 리턴 xvalue
    static_cast<DWORD>(num1)    // 값으로 캐스팅 lvalue
    static_cast<DWORD&&>(num1)  // rvalue 참조로 캐스팅 xvalue
}
```

## Move Semantics의 예시

str1와 str2를 swap해야 하는 과정을 거칠 때 우리는 임시 변수(string tmp)를 만들어 임시 변수를 이용하여 값을 교체하는 과정을 거쳐왔다. 하지만 이 과정에서 복사가 세번 일어나게 된다. 우리는 굳이 문자열 내용을 복사할 필요 없이 string_content의 주소값만 서로 바꿔주면 되는것을 알고 있다. 좌측값이 우측값으로 취급될 수 있게 바꿔주는 함수가 없을까?
std::move를 사용하자!

**Move Semantics**
```cpp
#include <cstring>
#include <algorithm>

class string
{
    char* data;

public:

    string(const char* p)
    {
        size_t size = std::strlen(p) + 1;
        data = new char[size];
        std::memcpy(data, p, size);
    }
```

Move Semantics에 대한 자세한 정보는 [microsoft 공식 문서](https://docs.microsoft.com/ko-kr/cpp/cpp/move-constructors-and-move-assignment-operators-cpp?view=msvc-160), [stackoverflow](https://stackoverflow.com/questions/3106110/what-is-move-semantics)을 참조하면 더 많은 정보를 얻을 수 있다.

## Array

Modern C++에서는 C/C++의 기본 문법이였던 배열을 STL로 지원해준다.
기존 STL을 사용할 때 우리는 Vector을 많이 사용해왔고 사실 Vector는 생성과 소멸에 드는 비용이 꽤 크고, 한 벡터의 객체는 4byte로 메모리를 비효율적으로 사용할 수 있다.

## nullptr 

C++11부터 추가된 키워드로 널포인터를 뜻한다.
nullptr은 포인터만을 위한 NULL상수이다. Modern C++이전까지는 널포인터를 나타내기 위해 상수 '0'을 사용했는데 함수 인자로 넘기게 되었을 때 정수형으로 추론되는 경우가 있어 문제가 발생하였고 이 문제를 해결하기 위하여 nullptr이 등장했다.

## 다양한 Library

### Thread Library
기존 C/C++에서는 스레드를 사용할 때 Window는 Win32 API, 리눅스는 pthread를 사용하여야만 했다. Modern C++에서는 스레드에 관한 라이브러리가 표준으로 포함되어 스레드를 다루기에 매우 편리해졌다.

### Regex Library
정규식은 Modern C++에서 표준 라이브러리에 포함되었다. std::regex 등을 사용하여 정규식을 사용할 수 있다.
