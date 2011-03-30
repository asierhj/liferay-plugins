create index IX_1F4986AF on KB_Article (companyId, latest);
create index IX_7B75ADE1 on KB_Article (companyId, main);
create index IX_C3F0585A on KB_Article (companyId, status);
create index IX_8A8C3831 on KB_Article (groupId, latest);
create index IX_4B5AD7E3 on KB_Article (groupId, main);
create index IX_1FC5BAD6 on KB_Article (groupId, parentResourcePrimKey, latest);
create index IX_35EEBFC8 on KB_Article (groupId, parentResourcePrimKey, main);
create index IX_C46C8C81 on KB_Article (groupId, parentResourcePrimKey, status);
create index IX_2F3309DC on KB_Article (groupId, status);
create index IX_5C7BA5D8 on KB_Article (parentResourcePrimKey, latest);
create index IX_5C7834A on KB_Article (parentResourcePrimKey, main);
create index IX_1227783 on KB_Article (parentResourcePrimKey, status);
create index IX_330AA4A7 on KB_Article (resourcePrimKey);
create index IX_A31C1BE3 on KB_Article (resourcePrimKey, groupId);
create index IX_5B16F61E on KB_Article (resourcePrimKey, groupId, latest);
create index IX_71662D10 on KB_Article (resourcePrimKey, groupId, main);
create index IX_FFBDC7C9 on KB_Article (resourcePrimKey, groupId, status);
create index IX_FC627AE2 on KB_Article (resourcePrimKey, latest);
create index IX_A69412D4 on KB_Article (resourcePrimKey, main);
create index IX_A1094C8D on KB_Article (resourcePrimKey, status);
create unique index IX_A7A71D41 on KB_Article (resourcePrimKey, version);
create index IX_3D477900 on KB_Article (uuid_);
create unique index IX_1B961BAA on KB_Article (uuid_, groupId);

create index IX_8914D7F2 on KB_Comment (classNameId, classPK);
create index IX_F91333ED on KB_Comment (groupId);
create index IX_D2044E81 on KB_Comment (groupId, classNameId);
create unique index IX_14BFFBAC on KB_Comment (userId, classNameId, classPK);
create index IX_94EDDB7 on KB_Comment (uuid_);
create unique index IX_381F14D3 on KB_Comment (uuid_, groupId);

create index IX_B8FC1FE2 on KB_Template (groupId);
create index IX_7EFC42EC on KB_Template (uuid_);
create unique index IX_61E7BB3E on KB_Template (uuid_, groupId);