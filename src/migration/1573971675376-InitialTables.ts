import {MigrationInterface, QueryRunner} from "typeorm";

export class InitialTables1573971675376 implements MigrationInterface {
    name = 'InitialTables1573971675376'

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`CREATE TABLE "owner" ("id" int NOT NULL IDENTITY(1,1), "name" nvarchar(255) NOT NULL, "email" nvarchar(255) NOT NULL, "contact_no" nvarchar(255) NOT NULL, "created_at" datetime2 NOT NULL CONSTRAINT "DF_be784758029428f309481ffdbbf" DEFAULT getdate(), "updated_at" datetime2 NOT NULL CONSTRAINT "DF_73509c8ebf61fb8ad756d1a46f3" DEFAULT getdate(), CONSTRAINT "PK_8e86b6b9f94aece7d12d465dc0c" PRIMARY KEY ("id"))`, undefined);
        await queryRunner.query(`CREATE TABLE "property" ("id" int NOT NULL IDENTITY(1,1), "address" nvarchar(255) NOT NULL, "created_at" datetime2 NOT NULL CONSTRAINT "DF_81198b0b6b914eeead02c2214d2" DEFAULT getdate(), "updated_at" datetime2 NOT NULL CONSTRAINT "DF_e02237374f140f496afbc987263" DEFAULT getdate(), "owner_id" int, CONSTRAINT "PK_d80743e6191258a5003d5843b4f" PRIMARY KEY ("id"))`, undefined);
        await queryRunner.query(`CREATE TABLE "user" ("id" int NOT NULL IDENTITY(1,1), "name" nvarchar(255) NOT NULL, "contact_no" nvarchar(255) NOT NULL, "created_at" datetime2 NOT NULL CONSTRAINT "DF_d091f1d36f18bbece2a9eabc6e0" DEFAULT getdate(), "updated_at" datetime2 NOT NULL CONSTRAINT "DF_9cdce43fa0043c794281aa09051" DEFAULT getdate(), CONSTRAINT "PK_cace4a159ff9f2512dd42373760" PRIMARY KEY ("id"))`, undefined);
        await queryRunner.query(`CREATE TABLE "booking" ("id" int NOT NULL IDENTITY(1,1), "price" int NOT NULL, "booking_date" date NOT NULL, "check_in" datetime NOT NULL, "check_out" datetime NOT NULL, "created_at" datetime2 NOT NULL CONSTRAINT "DF_5f3da1d174503855f57421f692d" DEFAULT getdate(), "updated_at" datetime2 NOT NULL CONSTRAINT "DF_e3cc0c008e9a70922a8f04a3641" DEFAULT getdate(), "user_id" int, "property_id" int, CONSTRAINT "PK_49171efc69702ed84c812f33540" PRIMARY KEY ("id"))`, undefined);
        await queryRunner.query(`CREATE TABLE "payment" ("id" int NOT NULL IDENTITY(1,1), "status" nvarchar(255) NOT NULL, "amount" int NOT NULL, "created_at" datetime2 NOT NULL CONSTRAINT "DF_2216ad74f64b73c04d5fb3c3610" DEFAULT getdate(), "updated_at" datetime2 NOT NULL CONSTRAINT "DF_6765c894a5ccf625b7b0a4ac9e3" DEFAULT getdate(), "booking_id" int, CONSTRAINT "PK_fcaec7df5adf9cac408c686b2ab" PRIMARY KEY ("id"))`, undefined);
        await queryRunner.query(`CREATE TABLE "tag" ("id" int NOT NULL IDENTITY(1,1), "label" nvarchar(255) NOT NULL, "created_at" datetime2 NOT NULL CONSTRAINT "DF_7561a113607b9a3804c895442aa" DEFAULT getdate(), "updated_at" datetime2 NOT NULL CONSTRAINT "DF_12e318242b90834fb3b94c5654d" DEFAULT getdate(), "property_id" int, CONSTRAINT "PK_8e4052373c579afc1471f526760" PRIMARY KEY ("id"))`, undefined);
        await queryRunner.query(`ALTER TABLE "property" ADD CONSTRAINT "FK_2541d2fb798d385a0521553370d" FOREIGN KEY ("owner_id") REFERENCES "owner"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`, undefined);
        await queryRunner.query(`ALTER TABLE "booking" ADD CONSTRAINT "FK_276896d1a1a30be6de9d7d43f53" FOREIGN KEY ("user_id") REFERENCES "user"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`, undefined);
        await queryRunner.query(`ALTER TABLE "booking" ADD CONSTRAINT "FK_5597161ba02971a62c629fc5a44" FOREIGN KEY ("property_id") REFERENCES "property"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`, undefined);
        await queryRunner.query(`ALTER TABLE "payment" ADD CONSTRAINT "FK_cee78453638dfaf440f1aa63c26" FOREIGN KEY ("booking_id") REFERENCES "booking"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`, undefined);
        await queryRunner.query(`ALTER TABLE "tag" ADD CONSTRAINT "FK_5a57171d80d68a286a52f283dc2" FOREIGN KEY ("property_id") REFERENCES "property"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`, undefined);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "tag" DROP CONSTRAINT "FK_5a57171d80d68a286a52f283dc2"`, undefined);
        await queryRunner.query(`ALTER TABLE "payment" DROP CONSTRAINT "FK_cee78453638dfaf440f1aa63c26"`, undefined);
        await queryRunner.query(`ALTER TABLE "booking" DROP CONSTRAINT "FK_5597161ba02971a62c629fc5a44"`, undefined);
        await queryRunner.query(`ALTER TABLE "booking" DROP CONSTRAINT "FK_276896d1a1a30be6de9d7d43f53"`, undefined);
        await queryRunner.query(`ALTER TABLE "property" DROP CONSTRAINT "FK_2541d2fb798d385a0521553370d"`, undefined);
        await queryRunner.query(`DROP TABLE "tag"`, undefined);
        await queryRunner.query(`DROP TABLE "payment"`, undefined);
        await queryRunner.query(`DROP TABLE "booking"`, undefined);
        await queryRunner.query(`DROP TABLE "user"`, undefined);
        await queryRunner.query(`DROP TABLE "property"`, undefined);
        await queryRunner.query(`DROP TABLE "owner"`, undefined);
    }

}
