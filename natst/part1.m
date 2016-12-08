x=[1:8]';
y=[1.5 2.3 1.7 2.0 2.5 1.9 2.2 2.4]';
X=[ones(size(x)) x];
[b,bint] = regress(y,X)

mu=X*b;
plot(x,y,'*',x,mu,'-')
xlabel('x: inställning')
ylabel('y: dimension')

