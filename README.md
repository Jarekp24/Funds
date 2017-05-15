funds

Aplikacja składa się z kilku interfejsów:

-CalculateService: tworzy obliczenia 

-FundsService: tworzona jest lista przykładowych funduszy 

-DivisionService: tworzy listę funduszy wraz z kwotami i procentami

Do działa applikacji w interfejsie calculateService stworzyłem kilka metod które tworzą różne obliczenia:

    metoda numberOfFundType - zwraca mape z iloscia powtorzen danego fundusza
    metoda percentagesForFundType - zwraca mape, z obliczonymi procentami dla kazdego typu fundusza
    metoda percentagesValues - zwraca typy i wartosci w procentach które mogą wystąpić
    metoda listOfObjectsForCalculation - zwraca listę kwot i procentów dla każdego fundusza

Klasa Algorithm wykonuje szereg potrzebnych obliczeń do uzyskania wyniku.

Klasa App jest klasą main w której uruchamiany jest cały algorytm z obliczeniami, metoda start z klasy Algorithm przyjmuje parametry : kwotę którą chcemy podzielić na fundusze, profil inwestycyjny oraz listę przykładowych funduszy.
