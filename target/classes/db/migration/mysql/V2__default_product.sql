INSERT INTO `product` (`id`, `name`, `date`, `baseproduct`) VALUES (NULL, 'maçã', CURRENT_DATE(), NULL);
INSERT INTO `product` (`id`, `name`, `date`, `baseproduct`) VALUES (NULL, 'maçã galã', CURRENT_DATE(),(select id from (select id from product where name='maçã') subquery));