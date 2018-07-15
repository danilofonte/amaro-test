CREATE TABLE PRODUCTS
(
   HJMPTS bigint,
   CREATEDTS timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
   MODIFIEDTS timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
   TYPEPKSTRING bigint,
   OWNERPKSTRING bigint,
   id bigint NOT NULL,
   P_CODE varchar(255),
   P_UNIT bigint,
   P_THUMBNAIL bigint,
   P_PICTURE bigint,
   P_CATALOG bigint,
   P_CATALOGVERSION bigint,
   P_ONLINEDATE timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
   P_OFFLINEDATE timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
   P_EAN varchar(255),
   P_SUPPLIERALTERNATIVEAID varchar(255),
   P_BUYERIDS longblob,
   P_MANUFACTURERAID varchar(255),
   P_MANUFACTURERNAME varchar(255),
   P_ERPGROUPBUYER varchar(255),
   P_ERPGROUPSUPPLIER varchar(255),
   P_DELIVERYTIME double,
   P_SPECIALTREATMENTCLASSES longblob,
   P_ORDER int,
   P_APPROVALSTATUS bigint,
   P_CONTENTUNIT bigint,
   P_NUMBERCONTENTUNITS double,
   P_MINORDERQUANTITY int,
   P_MAXORDERQUANTITY int,
   P_ORDERQUANTITYINTERVAL int,
   P_PRICEQUANTITY double,
   P_NORMAL longtext,
   P_THUMBNAILS longtext,
   P_DETAIL longtext,
   P_LOGO longtext,
   P_DATA_SHEET longtext,
   P_OTHERS longtext,
   P_STARTLINENUMBER int,
   P_ENDLINENUMBER int,
   P_VARIANTTYPE bigint,
   P_EUROPE1PRICEFACTORY_PPG bigint,
   P_EUROPE1PRICEFACTORY_PTG bigint,
   P_EUROPE1PRICEFACTORY_PDG bigint,
   P_BAND bigint,
   ACLTS bigint,
   PROPTS bigint,
   P_BASEPRODUCT bigint,
   P_VENUE varchar(255),
   P_DATE timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
   P_CONCERTTYPE bigint
)
;
CREATE INDEX BASEPRODUCTRELIDX_1 ON PRODUCTS(P_BASEPRODUCT)
;
CREATE INDEX BANDRELIDX_1 ON PRODUCTS(P_BAND)
;
CREATE INDEX CATALOGIDX_1 ON PRODUCTS(P_CATALOG)
;
CREATE UNIQUE INDEX CODEVERSIONIDX_1 ON PRODUCTS
(
  P_CODE,
  P_CATALOGVERSION
)
;
CREATE INDEX VISIBILITYIDX_1 ON PRODUCTS
(
  P_APPROVALSTATUS,
  P_ONLINEDATE,
  P_OFFLINEDATE
)
;
CREATE INDEX PRODUCT_CODE_1 ON PRODUCTS(P_CODE)
;
CREATE INDEX VERSIONIDX_1 ON PRODUCTS(P_CATALOGVERSION)
;
CREATE UNIQUE INDEX SYS_IDX_SYS_PK_10657_10658 ON PRODUCTS(id)
;