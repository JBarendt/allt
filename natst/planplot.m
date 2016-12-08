function planplot(x1,x2,b,y,nl)
% planplot(x1,x2,b,y)
%
% Plottar regressionsplan och datapunkter med en linje fr�n planet.

% Modell: y = [1 x1 x2]*b, b kunde lika g�rna r�knas ut h�r, men
% beh�lles som parameter f�r bak�tkompabilitet.

% 20000213 Joakim L�beck

if nargin < 5
   nl = 20; % Antal linjer i planet
end

rx1 = max(x1)-min(x1);
rx2 = max(x2)-min(x2);

% L�t regressionsplanet sticka ut 10% av intervallbredden �t
% vardera h�ll
r = 0.1;

[xl1, xl2] = meshgrid(linspace(min(x1)-r*rx1,max(x1)+r*rx1,nl)', ...
                      linspace(min(x2)-r*rx2,max(x2)+r*rx2,nl)');

yl = b(1)+b(2)*xl1+b(3)*xl2;

% Regressionsplan
s=mesh(xl1,xl2,yl);
set(s, 'FaceColor', 'none', 'EdgeColor', [1 0 0])

% Datapunkter
line(x1,x2,y,'Marker','*','LineStyle','none')

% Linje fr�n planet till datapunkten
line([x1'; x1'],[x2'; x2'],...
     [y';([ones(size(x1)) x1 x2]*b)'], 'Color',[0 0 1])

% Orginalkod av ok�nd f�rfattare:
% figure
% [U,V] = meshgrid(x1,x2);
% Yhat = b(1)*ones(size(U))+b(2)*U+b(3)*V;
% meshz(U,V,Yhat)
% hold on
% plot3(x1,x2,y,'o')
