load frost
figure(1)
plot(x1,y,'*')
xlabel('x1: höjd över havet')
ylabel('y: antal frostdagar')

figure(2)
 plot(x2,y,'*')
xlabel('x2: latitude')
ylabel('y: antal frostdagar')

%  reggui(x1,y)
%  reggui(x2,y)
% 
% X=[ones(size(x1)) x1 x2]
% [b Ib r] = regress(y,X)
% 
% figure(3)
% plot(x1,r,'*')
% xlabel('x1: höjd över havet')
% ylabel('residuals')
% 
% figure(4)
% plot(x2,r,'*')
% xlabel('x2: latitud')
% ylabel('residuals')
% 
% figure(5)
% normplot(r)

x0=[1 2000 40];
mu0=x0*b
Q0=r'*r
f=length(y)-length(b)
s=sqrt(Q0/f)
dmu0=s*sqrt(x0*inv(X'*X)*x0')
Imu0=mu0+tinv(1-0.05/2, f) * dmu0*[-1 1]

figure(3)
planplot(x1, x2, b, y)
xlabel('x1: höjd över hav')
ylabel('x2: latitud')
zlabel('y: antal frostdagar')