int fatorial(int n) {
    int f = 1;
    while( n > 0 )
        f *= n--;
    return f;
}
